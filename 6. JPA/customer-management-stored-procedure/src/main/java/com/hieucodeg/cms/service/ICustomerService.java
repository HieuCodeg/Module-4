package com.hieucodeg.cms.service;

import com.hieucodeg.cms.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
