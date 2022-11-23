package com.hieucodeg.controller;

import com.hieucodeg.model.Cart;
import com.hieucodeg.model.Product;
import com.hieucodeg.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/info/{id}")
    public ModelAndView showInfo(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/info");
        Product product = productService.findById(id).get();
        modelAndView.addObject("product",product);
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/";
    }
}
