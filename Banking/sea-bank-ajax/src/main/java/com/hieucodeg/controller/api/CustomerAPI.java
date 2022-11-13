package com.hieucodeg.controller.api;


import com.hieucodeg.exception.DataInputException;
import com.hieucodeg.exception.EmailExistsException;
import com.hieucodeg.model.Customer;
import com.hieucodeg.model.Deposit;
import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.Withdraw;
import com.hieucodeg.model.dto.*;
import com.hieucodeg.service.customer.ICustomerService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerAPI {

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private AppUtils appUtils;

    @GetMapping("/customers")
    public ResponseEntity<?> findAllByDeletedIsFalse() {

        List<Customer> customers = customerService.findAllByDeletedIsFalse();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long customerId) {

        Optional<Customer> customerOptional = customerService.findById(customerId);

        if (!customerOptional.isPresent()) {
            throw new DataInputException("ID khách hàng không hợp lệ");
        }

        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<?> create(@Validated @RequestBody Customer customer,BindingResult bindingResult) {

        Optional<Customer> customerOptional = customerService.findByEmail(customer.getEmail());

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        if (customerOptional.isPresent()) {
            throw new EmailExistsException("Email đã tồn tại");
        }

        customer.setId(0L);
        customer.setBalance(BigDecimal.ZERO);
        Customer newCustomer = customerService.save(customer);

        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

//    @PatchMapping("/customers/{customerId}")
//        public ResponseEntity<?> update(@PathVariable String customerIdStr,@Validated @RequestBody Customer customer,BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return appUtils.mapErrorToResponse(bindingResult);
//        }
//        Long customerId = Long.parseLong(customerIdStr);
//        Optional<Customer> customerOptional = customerService.findById(customerId);
//
//        if (!customerOptional.isPresent()) {
//            throw new DataInputException("ID khách hàng không hợp lệ");
//        }
//
//        Optional<Customer> emailOptional = customerService.findByEmailAndIdIsNot(customer.getEmail(), customerId);
//
//        if (emailOptional.isPresent()) {
//            throw new EmailExistsException("Email đã tồn tại!");
//        }
//
//        customer.setId(customerId);
//        customer.setBalance(customerOptional.get().getBalance());
//        Customer updatedCustomer = customerService.save(customer);
//
//        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
//    }
@PatchMapping("/customers/{customerIdStr}")
public ResponseEntity<?> update(@PathVariable String customerIdStr,@Validated @RequestBody CustomerDTO customerDTO,BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
        return appUtils.mapErrorToResponse(bindingResult);
    }
    Long customerId = Long.parseLong(customerIdStr);
    Optional<Customer> customerOptional = customerService.findById(customerId);
    Customer customer = customerOptional.get();

    if (!customerOptional.isPresent()) {
        throw new DataInputException("ID khách hàng không hợp lệ");
    }

    Optional<Customer> emailOptional = customerService.findByEmailAndIdIsNot(customerDTO.getEmail(), customerId);

    if (emailOptional.isPresent()) {
        throw new EmailExistsException("Email đã tồn tại!");
    }


    customer.setId(customerId);
    customer.setFullName(customerDTO.getFullName());
    customer.setEmail(customerDTO.getEmail());
    customer.setPhone(customerDTO.getPhone());
    customer.setAddress(customerDTO.getAddress());
    Customer updatedCustomer = customerService.save(customer);

    return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
}

    @PostMapping("/deposits")
    public ResponseEntity<?> deposit(@Validated @RequestBody DepositDTO depositDTO,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        long id = Long.parseLong(depositDTO.getCustomerId());
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            throw new DataInputException("ID khách hàng không hợp lệ");
        }

        Deposit deposit = new Deposit();
        BigDecimal transactionAmount = new BigDecimal(depositDTO.getTransactionAmount());
        deposit.setTransactionAmount(transactionAmount);
        deposit.setCustomer(customerOptional.get());

        Customer newCustomer = customerService.deposit(deposit, customerOptional.get());
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PostMapping("/withdraws")
    public ResponseEntity<?> withdraw(@Validated @RequestBody WithdrawDTO withdrawDTO,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        long id = Long.parseLong(withdrawDTO.getCustomerId());
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()) {
            throw new DataInputException("ID khách hàng không hợp lệ");
        }
        Withdraw withdraw = new Withdraw();
        BigDecimal transactionAmount = new BigDecimal(withdrawDTO.getTransactionAmount());
        withdraw.setTransactionAmount(transactionAmount);
        withdraw.setCustomer(customerOptional.get());

        if (customerOptional.get().getBalance().compareTo(withdraw.getTransactionAmount()) < 0) {
            throw new DataInputException("Số dư tài khoản không đủ");
        }

        Customer newCustomer = customerService.withdraw(withdraw, customerOptional.get());
        return new ResponseEntity<>(newCustomer.toCustomerDTO(), HttpStatus.CREATED);
    }
    @PostMapping("/transfers")
    public ResponseEntity<?> transfer(@Validated @RequestBody TransferDTO transferDTO,BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        Optional<Customer> senderOptional = customerService.findById(Long.parseLong(transferDTO.getSenderId()));
        if (!senderOptional.isPresent()) {
            throw new DataInputException("ID người gửi không tồn tại");
        }
        Customer sender = senderOptional.get();
        Optional<Customer> recipientOptional = customerService.findById(Long.parseLong(transferDTO.getRecipientId()));
        if (!recipientOptional.isPresent()) {
            throw new DataInputException("ID người nhận không tồn tại");
        }
        Customer recipient = recipientOptional.get();

        BigDecimal transferAmount = new BigDecimal(Long.parseLong(transferDTO.getTransferAmount()));
        BigDecimal currentBalanceSender = sender.getBalance();
        long  fees = 10;
        BigDecimal  feesAmount = transferAmount.multiply(new BigDecimal(fees)).divide(new BigDecimal(100L));
        BigDecimal transactionAmount = transferAmount.add(feesAmount);

        if (currentBalanceSender.compareTo(transactionAmount) < 0) {
            throw new DataInputException("Số dư người gửi không đủ thực hiện giao dịch");
        }
        Transfer transfer = new Transfer();
        try {
            transfer.setId(0L);
            transfer.setSender(sender);
            transfer.setFees(fees);
            transfer.setFeesAmount(feesAmount);
            transfer.setTransactionAmount(transactionAmount);
            transfer.setTransferAmount(transferAmount);
            transfer.setRecipient(recipient);
            customerService.transfer(transfer);
        } catch (Exception e) {
            throw new DataInputException("Thao tác không thành công, vui lòng liên hệ Administrator");
        }

        Map<String, CustomerDTO> results = new HashMap<>();
        results.put("sender", sender.toCustomerDTO());
        results.put("recipient", recipient.toCustomerDTO());

        return new ResponseEntity<>(results, HttpStatus.CREATED);
    }

}
