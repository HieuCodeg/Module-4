package com.hieucodeg.repository;

import com.hieucodeg.exception.BadWordlException;

import java.util.List;

public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t) throws BadWordlException;

    void remove(Long id);
}
