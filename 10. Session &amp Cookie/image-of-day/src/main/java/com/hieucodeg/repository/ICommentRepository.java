package com.hieucodeg.repository;

import com.hieucodeg.exception.BadWordlException;
import com.hieucodeg.model.Comment;

import java.util.HashSet;

public interface ICommentRepository extends IGeneralRepository<Comment>{
    public void save(Comment comment, HashSet<String> badList) throws BadWordlException;
}
