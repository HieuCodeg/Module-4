package com.hieucodeg.controller;

import com.hieucodeg.model.Customer;
import com.hieucodeg.service.customer.ICustomerService;
import com.hieucodeg.service.transfer.ITransferService;
import com.hieucodeg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private AppUtils appUtils;

    @Autowired
    private ITransferService transferService;
    @GetMapping
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/home");

        String username = appUtils.getPrincipalUsername();

        modelAndView.addObject("username", username);

        return modelAndView;
    }



}
