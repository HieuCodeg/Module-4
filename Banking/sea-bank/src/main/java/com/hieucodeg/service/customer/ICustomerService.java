package com.hieucodeg.service.customer;


import com.hieucodeg.model.Customer;
import com.hieucodeg.model.Deposit;
import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.Withdraw;
import com.hieucodeg.service.IGeneralService;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    void deposit(Deposit deposit, Customer customer);
    void withdraw(Withdraw withdraw, Customer customer);
    List<Customer> findAllByIdNot(Long senderId);
    void transfer(Transfer transfer);
    List<Customer> findAllByDeletedIsFalse();
}
