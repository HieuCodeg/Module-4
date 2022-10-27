package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SimpleCustomerServiceImpl implements CustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 0;

    static {
        customers = asList(
                new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"),
                new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"),
                new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"),
                new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"),
                new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang")
        );
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer findOne(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customer.getId() == null ? persist(customer) : merge(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return customers.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customers.stream().anyMatch(c -> c.getId().equals(id));
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return ids.stream()
                .map(this::findOne)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customers.size();
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public void delete(Customer customer) {
        delete(customer.getId());
    }

    @Override
    public void delete(List<Customer> customers) {
        customers.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        customers = new ArrayList<>();
    }

    private Customer persist(Customer customer) {
        Customer clone = customer.clone();
        clone.setId(autoIncreaseId++);
        customers.add(clone);
        return clone;
    }

    private Customer merge(Customer customer) {
        Customer origin = findOne(customer.getId());
        origin.setName(customer.getName());
        origin.setEmail(customer.getEmail());
        origin.setAddress(customer.getAddress());
        return origin;
    }
}
