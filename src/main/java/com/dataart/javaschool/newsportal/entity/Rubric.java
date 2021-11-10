package com.dataart.javaschool.newsportal.entity;


import com.dataart.javaschool.newsportal.model.RubricModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@EqualsAndHashCode
@Builder
@Data
@Table("RUBRIC")
@AllArgsConstructor
@NoArgsConstructor
public class Rubric {
    @Id
    private String RUBRIC_NAME;

    public RubricModel toRubricModel () {
        return new RubricModel(
                RUBRIC_NAME
        );
    }
}
