package com.hieucodeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("/")
    public String showIndex() {
        return "redirect:/customers";
    }

    @GetMapping("/login")
    public ModelAndView getLogin() {

        return new ModelAndView("login");
    }

    @GetMapping("/transfer-history")
    public ModelAndView showTransferInformation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("transfer/transferInformation");
        return modelAndView;
    }

}