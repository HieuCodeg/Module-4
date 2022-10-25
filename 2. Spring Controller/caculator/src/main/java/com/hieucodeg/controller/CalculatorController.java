package com.hieucodeg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static jdk.nashorn.internal.objects.Global.Infinity;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String exchange() {
        return "index";
    }

    @RequestMapping("/caculator")
    public String load(@RequestParam("first") Double first,
                       @RequestParam("second") Double second,
                       @RequestParam("operation") String operation,
                       Model model){
        Double tamp = Double.valueOf(0);
        String result = null;

            switch (operation) {
                case "+":
                    tamp = first + second;
                    break;
                case "-":
                    tamp = first - second;
                    break;
                case "*":
                    tamp = first * second;
                    break;
                case "/":
                    tamp = first / second;
                    break;
            }
        if (tamp.equals(Infinity)) {
            result = "Can't divice 0";
        }


        if (result == null) {
            result = String.valueOf(tamp);
        }
        model.addAttribute("first",first);
        model.addAttribute("second",second);
        model.addAttribute("result",result);
        return "index";
    }

}