package com.hieucodeg.controller;

import com.hieucodeg.model.Product;
import com.hieucodeg.service.IProductService;
import com.hieucodeg.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/home")
    public String index(Model model) {

        return "cp/index";
    }


}
