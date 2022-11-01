package com.hieucodeg.repository;

import com.hieucodeg.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
@Transactional
public class CommentRepository implements ICommentRepository{

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Comment> findAll() {
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c where c.dateComment = :dater", Comment.class);
        query.setParameter("dater",new Date(System.currentTimeMillis()));
        return query.getResultList();
    }

    @Override
    public Comment findById(Long id) {
        TypedQuery<Comment> query = em.createQuery("SELECT c FROM Comment c WHERE c.id = :id", Comment.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Override
    public void save(Comment comment) {
        if (comment.getId() != null) {
            comment.setLike(comment.getLike() + 1);
            em.merge(comment);
        } else {
            comment.setDateComment(new Date(System.currentTimeMillis()));
            em.persist(comment);
        }
    }

    @Override
    public void remove(Long id) {

    }
}
