package com.dataart.javaschool.newsportal.service;

import com.dataart.javaschool.newsportal.entity.Rubric;
import com.dataart.javaschool.newsportal.model.RubricModel;
import com.dataart.javaschool.newsportal.repository.RubricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RubricsService {
    public final RubricRepository rubricRepository;

    public List<RubricModel> getRubrics () {
        List<Rubric> rubrics = rubricRepository.findAll();
        List<RubricModel> res = new ArrayList<>();
        for (Rubric rub : rubrics) { res.add(new RubricModel(rub.getRUBRIC_NAME())); }
        return res;
    }
}
