package com.dataart.javaschool.newsportal.service;

import com.dataart.javaschool.newsportal.entity.Article;
import com.dataart.javaschool.newsportal.entity.Article_and_rubric;
import com.dataart.javaschool.newsportal.entity.Rubric;
import com.dataart.javaschool.newsportal.exception.ArticleHasTwoLessLinesException;
import com.dataart.javaschool.newsportal.exception.FileIsNotZipException;
import com.dataart.javaschool.newsportal.exception.FileNotFoundException;
import com.dataart.javaschool.newsportal.exception.ZipFileHasOneMoreFileException;
import com.dataart.javaschool.newsportal.model.ArticleAndRubric;
import com.dataart.javaschool.newsportal.model.ArticleFull;
import com.dataart.javaschool.newsportal.model.RubricModel;
import com.dataart.javaschool.newsportal.repository.ArticlesRepository;
import com.dataart.javaschool.newsportal.repository.RubricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


@RequiredArgsConstructor
@Service
public class ArticlesService {
    public final ArticlesRepository articlesRepository;

    public Page<Article> getArticlePages (Pageable pageable) {
        return articlesRepository.findAll(pageable);
    }


    public List<Article> getArticlesAndRubrics () {
        return articlesRepository.findAllArticles();
    }

    public List<Article> getArticlesAndRubricsFilteredByTags (List<RubricModel> rubrics) {
        List<String> rubricNames = new ArrayList<>();
        rubrics.forEach(rubric -> rubricNames.add(rubric.getRubricName()));
        return getArticlesAndRubricsFilteredByTags(rubricNames);
    }

    public List<Article> getArticlesAndRubricsFilteredByTags (Collection<String> rubrics) {
        Collection<Article> articles = articlesRepository.findAllArticles();
        List<Article> articleAndRubrics = new ArrayList<>();
        for (Article art : articles) {
            List<String> rubricNames = new ArrayList<>();
            art.getRubrics().forEach(rubric -> rubricNames.add(rubric.getRUBRIC_NAME()));
            if (rubricNames.containsAll(rubrics)) {
                articleAndRubrics.add(new Article(art.getARTICLE_ID(),
                        art.getJOURNALIST_ID(),
                        art.getHEADER(),
                        art.getBODY(),
                        art.getPUBLICATION_DATE(),
                        art.getRubrics()
                ));
            }
        }
        return articleAndRubrics;
    }

    public ArticleFull getArticleById (Long id) {
        Article article = articlesRepository.findArticleByARTICLE_ID(id);
        return new ArticleFull(article.getHEADER(), article.getBODY(), article.getRubrics());
    }

    public void insertArticle (Article article) {
        articlesRepository.insertArticle(article.getHEADER(), article.getBODY());
    }



}
