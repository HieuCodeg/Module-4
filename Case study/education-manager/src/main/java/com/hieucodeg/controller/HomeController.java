package com.hieucodeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping({""})
public class HomeController {
    @GetMapping
    public String login(Model model) {

        return "login/index";
    }

    @GetMapping("/home")
    public String index(Model model) {

        return "cp/index";
    }


}
