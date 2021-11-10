package com.dataart.javaschool.newsportal.model;

import com.dataart.javaschool.newsportal.entity.Article_and_rubric;
import lombok.Value;

import java.util.Set;

@Value
public class ArticleFull {
    String header;
    String body;
    Set<Article_and_rubric> rubrics;

    public ArticleFull (String header, String body, Set<Article_and_rubric> rubrics) {
        this.header = header;
        this.body = body;
        this.rubrics = rubrics;
    }
}
