package com.dataart.javaschool.newsportal.entity;

import com.dataart.javaschool.newsportal.model.ArticleAndRubric;
import com.dataart.javaschool.newsportal.model.ArticleFull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode
@Builder
@Data
@Table("ARTICLE")
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private Long ARTICLE_ID;
    private Long JOURNALIST_ID;
    private String HEADER;
    private String BODY;
    private String PUBLICATION_DATE;

    @MappedCollection(idColumn = "ARTICLE_ID" )
    private Set<Article_and_rubric> rubrics;

    public Article (String HEADER, String BODY, String PUBLICATION_DATE) {
        this.HEADER = HEADER;
        this.BODY = BODY;
        this.PUBLICATION_DATE = PUBLICATION_DATE;
    }

    public ArticleAndRubric toArticleAndRubric () {
        return new ArticleAndRubric(
                ARTICLE_ID,
                HEADER,
                BODY,
                getRubrics()
        );
    }

    public ArticleFull toArticleFull () {
        return new ArticleFull(
                HEADER,
                BODY,
                getRubrics()
        );
    }

    public boolean hasRubrics (List<String> rubrics) {
        List<String> rubricNames = new ArrayList<>();
        this.getRubrics().forEach(rubric -> rubricNames.add(rubric.getRUBRIC_NAME()));
        return rubricNames.containsAll(rubrics);
    }

}
