package cg.wbd.grandemonstration.service;

import cg.wbd.grandemonstration.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findOne(Long id);

    Customer save(Customer customer);

    List<Customer> save(List<Customer> customers);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
