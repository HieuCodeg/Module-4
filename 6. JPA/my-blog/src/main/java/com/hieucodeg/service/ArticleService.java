package com.hieucodeg.service;


import com.hieucodeg.model.Article;
import com.hieucodeg.repository.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleService implements IArticleService {
    @Autowired
    private IArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void remove(Long id) {
        articleRepository.remove(id);
    }
}
