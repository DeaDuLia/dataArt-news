package com.dataart.javaschool.newsportal.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode
@Builder
@Data
@Table("ARTICLE_AND_RUBRIC")
@AllArgsConstructor
@NoArgsConstructor
public class Article_and_rubric {
    @Id
    Long ARTICLE_ID;
    String RUBRIC_NAME;
}
