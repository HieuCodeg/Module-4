package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
//    @PostMapping
//    public String updateCustomer(
//            @RequestParam Long id,
//            @RequestParam String name,
//            @RequestParam String email,
//            @RequestParam String address
//    ) {
//        Customer customer = new Customer(id, name, email, address);
//        customerService.save(customer);
//        return "redirect:/customers";
//    }

    @PostMapping
    public String updateCustomer(Customer customer) {
        customerService.save(customer);
        return "redirect:/customers";
    }

}


