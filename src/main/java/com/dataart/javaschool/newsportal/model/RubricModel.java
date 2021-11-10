package com.dataart.javaschool.newsportal.model;

import lombok.Value;

@Value
public class RubricModel {
    String rubricName;

    public RubricModel(String rubricName) {
        this.rubricName = rubricName;
    }
}
