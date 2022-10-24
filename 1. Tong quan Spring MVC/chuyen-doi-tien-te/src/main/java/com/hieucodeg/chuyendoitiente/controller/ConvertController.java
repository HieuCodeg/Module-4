package com.hieucodeg.chuyendoitiente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String exchange() {
        return "index";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("rate") Double rate,@RequestParam("amount") Double amount, Model model) {
        Double result = rate * amount;
        model.addAttribute("rate",rate);
        model.addAttribute("amount",amount);
        model.addAttribute("result",result);

        return "result";
    }
}


