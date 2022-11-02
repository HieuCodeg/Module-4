package com.hieucodeg.controller;

import com.hieucodeg.model.Article;
import com.hieucodeg.model.Category;
import com.hieucodeg.service.IArticleService;
import com.hieucodeg.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.Optional;


@Controller
public class HomeController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping()
    public String loadHome(@RequestParam("search") Optional<String> search, Model model, Pageable pageable) {
        Page<Article> articleList;
        if (search.isPresent()) {
            articleList = articleService.findAllByTitleContaining(search.get(),pageable);
        } else {
            articleList = articleService.findAll(pageable);
        }
        model.addAttribute("articleList" ,articleList);
        return "home";
    }
    @GetMapping("/info/{id}")
    public ModelAndView loadHome(@PathVariable Long id) {
        Optional<Article> article = articleService.findById(id);
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("article", article.get());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Article> article = articleService.findById(id);
        if (article.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("article", article.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error.404");
            return modelAndView;
        }
    }
    @PostMapping("/edit")
    public String saveEdit(@ModelAttribute Article article){
        article.setDatePost(new Date());
        articleService.save(article);
        return "redirect:/";
    }
    @GetMapping("/create")
    public ModelAndView loadCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("article", new Article());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String loadDelete(@PathVariable Long id) {
        articleService.remove(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Article article){
        article.setDatePost(new Date());
        articleService.save(article);
        return "redirect:/";
    }


}
