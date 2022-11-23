package com.hieucodeg.controller;


import com.hieucodeg.exception.BadWordlException;
import com.hieucodeg.model.Comment;
import com.hieucodeg.service.CommentService;
import com.hieucodeg.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class HomeController {

    private static final Set<String> badList = new HashSet<String>() {{
        add("xau");
        add("ban");
        add("te");
    }};


    @Autowired
    private ICommentService commentService;


    @GetMapping
    public String showList(Model model) {
        List<Comment> commentList = commentService.findAll();
        model.addAttribute("commentList", commentList);
        model.addAttribute("comment", new Comment());
        return "home";
    }

    @PostMapping("/save")
    public String savecomment(Comment comment, Model model) throws BadWordlException {
        commentService.save(comment, (HashSet<String>) badList);

        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    public String vouch(@PathVariable Long id, Model model) {
        Comment comment = commentService.findById(id);
        commentService.save(comment);
        return "redirect:/";
    }

    @ExceptionHandler(BadWordlException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("badWord");
    }


}
