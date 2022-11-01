package com.hieucodeg.service;


import com.hieucodeg.model.Comment;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.Collections;
import java.util.List;

@Service
public class HibernateCommentServiceImpl implements CommentService {

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findAll() {
        String queryStr = "SELECT c FROM Comment AS c where c.dateComment = :date";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("date",new Date(System.currentTimeMillis()));
        return query.getResultList();
    }

    @Override
    public Comment findOne(Long id) {
        String queryStr = "SELECT c FROM Comment AS c WHERE c.id = :id";
        TypedQuery<Comment> query = entityManager.createQuery(queryStr, Comment.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Comment save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (comment.getId() == null) {
                Comment newComment = new Comment();
                newComment.setId(0L);
                newComment.setMark(comment.getMark());
                newComment.setAuthor(comment.getAuthor());
                newComment.setFeedback(comment.getFeedback());
                newComment.setLike(comment.getLike());
                newComment.setDateComment(new Date(System.currentTimeMillis()));
                session.save(newComment);
                transaction.commit();
                return newComment;
            } else {
                comment.setLike(comment.getLike() + 1);
                session.update(comment);
                transaction.commit();
                return comment;
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
}

    @Override
    public List<Comment> save(List<Comment> comments) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Comment> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void delete(List<Comment> comments) {

    }


    @Override
    public void deleteAll() {
    }
}
