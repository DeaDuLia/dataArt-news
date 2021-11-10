package com.dataart.javaschool.newsportal.repository;


import com.dataart.javaschool.newsportal.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticlesRepository extends CrudRepository<Article, Long> {

    Page<Article> findAll(Pageable pageable);

    @Query("select * from ARTICLE ORDER BY ARTICLE_ID DESC")
    List<Article> findAllArticles();

    @Query("SELECT * FROM ARTICLE WHERE HEADER = :HEADER ORDER BY ARTICLE_ID DESC")
    Article findArticleByHEADER(String HEADER);

    @Query("SELECT * FROM ARTICLE WHERE ARTICLE_ID = :ARTICLE_ID")
    Article findArticleByARTICLE_ID (Long ARTICLE_ID);

    @Modifying
    @Query("INSERT INTO ARTICLE (JOURNALIST_ID, HEADER, BODY, PUBLICATION_DATE) VALUES ( 2, :header, :body, SYSDATE)")
    void insertArticle(String header, String body);
}
