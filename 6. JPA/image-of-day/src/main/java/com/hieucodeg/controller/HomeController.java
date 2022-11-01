package com.hieucodeg.controller;


import com.hieucodeg.model.Comment;
import com.hieucodeg.service.CommentService;
import com.hieucodeg.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private ICommentService commentService;

    @GetMapping
    public String showList(Model model) {
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList",commentList);
        model.addAttribute("comment", new Comment());
        return "home";
    }
    @PostMapping("/save")
    public String savecomment(Comment comment,Model model) {
        commentService.save(comment);

        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String vouch(@PathVariable Long id,Model model) {
        Comment comment = commentService.findById(id);
        commentService.save(comment);
        return "redirect:/";
    }


}
