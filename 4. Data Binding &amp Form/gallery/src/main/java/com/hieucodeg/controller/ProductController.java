package com.hieucodeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    @GetMapping("/product")
    public String load(Model model) {

        return "cp/product/list";
    }


}
