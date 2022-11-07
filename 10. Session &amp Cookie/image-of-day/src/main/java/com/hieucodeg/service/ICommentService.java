package com.hieucodeg.service;

import com.hieucodeg.exception.BadWordlException;
import com.hieucodeg.model.Comment;

import java.util.HashSet;

public interface ICommentService extends IGeneralService<Comment>{

    public void save(Comment comment, HashSet<String> badList) throws BadWordlException;
}
