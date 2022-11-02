package com.hieucodeg.service;


import com.hieucodeg.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IArticleService extends IGeneralService<Article> {
    Page<Article> findAll(Pageable pageable);
    Page<Article> findAllByTitleContaining(String title, Pageable pageable);
}
