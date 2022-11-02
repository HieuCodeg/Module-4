package com.hieucodeg.repository;


import com.hieucodeg.model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IArticleRepository extends PagingAndSortingRepository<Article,Long> {
    Page<Article> findAllByTitleContaining(String title, Pageable pageable);
}
