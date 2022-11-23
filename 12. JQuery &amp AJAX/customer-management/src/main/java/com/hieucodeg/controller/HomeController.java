package com.hieucodeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String  showPage(){
        return "/test";
    }

    @GetMapping("/test")
    public String  showPage2(){
        return "/test2";
    }
}
