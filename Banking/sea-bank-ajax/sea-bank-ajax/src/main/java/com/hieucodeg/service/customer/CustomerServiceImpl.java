package com.hieucodeg.service.customer;



import com.hieucodeg.model.Customer;
import com.hieucodeg.model.Deposit;
import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.Withdraw;
import com.hieucodeg.repository.CustomerRepository;
import com.hieucodeg.repository.DepositRepository;
import com.hieucodeg.repository.TransferRepository;
import com.hieucodeg.repository.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepositRepository depositRepository;
    @Autowired
    private WithdrawRepository withdrawRepository;
    @Autowired
    private TransferRepository transferRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Customer deposit(Deposit deposit, Customer customer) {
        deposit.setId(0L);
        deposit.setCustomer(customer);
        depositRepository.save(deposit);

        BigDecimal newBalance = deposit.getTransactionAmount();
        customerRepository.incrementBalance(customer.getId(), newBalance);
        return  customer;
    }

    @Override
    public Customer withdraw(Withdraw withdraw, Customer customer) {
        withdraw.setId(0L);
        withdraw.setCustomer(customer);
        withdrawRepository.save(withdraw);

        BigDecimal newBalance = withdraw.getTransactionAmount();
        customerRepository.decreaseBalance(customer.getId(), newBalance);
        return customer;
    }

    @Override
    public List<Customer> findAllByIdNot(Long senderId) {
        return customerRepository.findAllByIdNot(senderId);
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Optional<Customer> findByEmailAndIdIsNot(String email, Long id) {
        return customerRepository.findByEmailAndIdIsNot(email,id);
    }

    @Override
    public void transfer(Transfer transfer) {
        Customer sender = transfer.getSender();

        customerRepository.decreaseBalance(transfer.getSender().getId(),transfer.getTransactionAmount());

        customerRepository.incrementBalance(transfer.getRecipient().getId(),transfer.getTransferAmount());

        transferRepository.save(transfer);
    }
    @Override
    public List<Customer> findAllByDeletedIsFalse() {
        return customerRepository.findAllByDeletedIsFalse();
    }

}
