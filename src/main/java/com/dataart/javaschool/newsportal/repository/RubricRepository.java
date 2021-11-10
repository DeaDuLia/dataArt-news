package com.dataart.javaschool.newsportal.repository;

import com.dataart.javaschool.newsportal.entity.Rubric;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RubricRepository  extends CrudRepository<Rubric, String> {

    @Query("SELECT * FROM RUBRIC")
    List<Rubric> findAll();
}
