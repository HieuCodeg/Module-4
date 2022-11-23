package com.hieucodeg.repository;


import com.hieucodeg.model.Article;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class ArticleRepository implements IArticleRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Article> findAll() {
        TypedQuery<Article> query = em.createQuery("select c from Article c", Article.class);
        return query.getResultList();
    }

    @Override
    public Article findById(Long id) {
        TypedQuery<Article> query = em.createQuery("select c from Article c where  c.id=:id", Article.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Article article) {
        if (article.getId() != null) {
            em.merge(article);
        } else {
            article.setDatePost(new Date());
            em.persist(article);
        }
    }

    @Override
    public void remove(Long id) {
        Article article = findById(id);
        if (article != null) {
            em.remove(article);
        }
    }
}
