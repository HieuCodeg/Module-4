package com.hieucodeg.controller;

import com.hieucodeg.model.Product;
import com.hieucodeg.service.ProductService;
import com.hieucodeg.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService iProductService = new ProductService();

    @GetMapping("")
    public String index(Model model) {

        List<Product> products = iProductService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        product.setId((int) (Math.random() * 10000));
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        iProductService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        iProductService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/find")
    public String find(@RequestParam("name") String name, Model model) {
        model.addAttribute("product", iProductService.findByName(name));
        return "/view";
    }
}
