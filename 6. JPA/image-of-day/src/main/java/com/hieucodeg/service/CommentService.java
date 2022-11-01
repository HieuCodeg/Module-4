package com.hieucodeg.service;


import com.hieucodeg.model.Comment;
import com.hieucodeg.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService implements ICommentService{

    @Autowired
    private ICommentRepository commentRepository;
    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {

    }
}
