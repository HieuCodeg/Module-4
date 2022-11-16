package com.hieucodeg.controller;

import com.hieucodeg.model.Customer;
import com.hieucodeg.model.Deposit;
import com.hieucodeg.model.Transfer;
import com.hieucodeg.model.Withdraw;
import com.hieucodeg.service.customer.ICustomerService;
import com.hieucodeg.service.transfer.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping({"/customers", ""})
public class HomeController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransferService transferService;
    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/home");
//        List<Customer> customers = customerService.findAllByDeletedIsFalse();
//        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/information")
    public ModelAndView showTransferInformation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/transferInformation");
//        List<Transfer> transfers = transferService.findAll();
//        modelAndView.addObject("transfers", transfers);
        return modelAndView;
    }

}
