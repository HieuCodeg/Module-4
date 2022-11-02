package com.hieucodeg.controller;

import com.hieucodeg.model.Article;
import com.hieucodeg.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private IArticleService articleService;

    @GetMapping()
    public String loadHome(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articleList" ,articleList);
        return "home";
    }
    @GetMapping("/info/{id}")
    public String loadHome(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article" ,article);
        return "info";
    }

    @GetMapping("/edit/{id}")
    public String loadEdit(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article" ,article);
        return "edit";
    }
    @GetMapping("/create")
    public String loadCreate(Model model) {
        model.addAttribute("article" ,new Article());
        return "create";
    }
    @GetMapping("/delete/{id}")
    public String loadDelete(@PathVariable Long id, Model model) {
        articleService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveEdit(@ModelAttribute Article article){
        articleService.save(article);
        return "redirect:/";
    }


}
