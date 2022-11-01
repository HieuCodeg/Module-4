package com.hieucodeg.service;


import com.hieucodeg.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Comment findOne(Long id);

    Comment save(Comment comment);

    List<Comment> save(List<Comment> comments);

    boolean exists(Long id);

    List<Comment> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Comment comment);

    void delete(List<Comment> comments);

    void deleteAll();
}
