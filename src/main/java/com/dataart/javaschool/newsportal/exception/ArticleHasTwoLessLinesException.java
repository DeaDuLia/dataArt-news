package com.dataart.javaschool.newsportal.exception;

public class ArticleHasTwoLessLinesException extends RuntimeException {
    public ArticleHasTwoLessLinesException(String message) {
        super(message);
    }
}
