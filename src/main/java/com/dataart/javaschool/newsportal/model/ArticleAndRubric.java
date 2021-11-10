package com.dataart.javaschool.newsportal.model;

import com.dataart.javaschool.newsportal.entity.Article_and_rubric;
import lombok.Value;

import java.util.Set;

@Value
public class ArticleAndRubric {
    static final int LENGTH = 256;
    Long id;
    String header;
    String bodyPreview;
    Set<Article_and_rubric> rubrics;
    public ArticleAndRubric (Long id, String header, String body, Set<Article_and_rubric> rubrics) {
        this.id = id;
        this.header = header;
        if (LENGTH < body.length()) {
            this.bodyPreview = body.substring(0, LENGTH) + "...";
        } else {
            this.bodyPreview = body;
        }
        this.rubrics = rubrics;
    }
}
