package com.dataart.javaschool.newsportal.entity;

import com.dataart.javaschool.newsportal.model.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@EqualsAndHashCode
@Builder
@Data
@Table("USER")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long USER_ID;

    private String FIRST_NAME;
    private String LAST_NAME;
    private String LOGIN;
    private String PASS;
    private String EMAIL;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private Status status;

}
