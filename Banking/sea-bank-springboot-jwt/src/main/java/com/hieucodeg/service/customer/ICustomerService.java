package com.hieucodeg.service.customer;


import com.hieucodeg.model.Customer;
import com.hieucodeg.model.Deposit;
import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.Withdraw;
import com.hieucodeg.model.dto.CustomerAvartasDTO;
import com.hieucodeg.model.dto.CustomerDTO;
import com.hieucodeg.service.IGeneralService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Customer deposit(Deposit deposit, Customer customer);
    Customer withdraw(Withdraw withdraw, Customer customer);
    List<Customer> findAllByIdNot(Long senderId);

    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByEmailAndIdIsNot(String email, Long id);
    void transfer(Transfer transfer);
    List<Customer> findAllByDeletedIsFalse();
    List<CustomerDTO> getAllCustomerDTO();
    List<CustomerAvartasDTO> getAllCustomersAvartaDTO();

    CustomerAvartasDTO saveWithAvatar(Customer customer, MultipartFile avatarFile);

}
