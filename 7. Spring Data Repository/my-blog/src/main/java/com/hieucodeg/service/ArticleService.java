package com.hieucodeg.service;


import com.hieucodeg.model.Article;
import com.hieucodeg.repository.IArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements IArticleService {
    @Autowired
    private IArticleRepository articleRepository;

    @Override
    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public void save(Article article) {
        articleRepository.save(article);
    }

    @Override
    public void remove(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Page<Article> findAllByTitleContaining(String title, Pageable pageable) {
        return articleRepository.findAllByTitleContaining(title,pageable);
    }
}
