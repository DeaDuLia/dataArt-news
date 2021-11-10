package com.dataart.javaschool.newsportal.controller;

import com.dataart.javaschool.newsportal.entity.Article;
import com.dataart.javaschool.newsportal.model.ArticleFull;
import com.dataart.javaschool.newsportal.model.RubricModel;
import com.dataart.javaschool.newsportal.service.ArticlesService;
import com.dataart.javaschool.newsportal.service.RubricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Controller
public class ArticlesController {

    private final ArticlesService articlesService;
    private final RubricsService rubricsService;
    private static final Integer PAGE_SIZE = 6;
    @PostMapping("/")
    public String index(@RequestParam(value = "checkboxName", required = false) List<String> checkboxValue,
                        @RequestParam(value = "page", required = false) Integer page,
                        Model model) {
        if (page == null) { page = 0; }
        List<RubricModel> rubrics = rubricsService.getRubrics();
        Page<Article> articlesPage = articlesService.getArticlePages(PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "ARTICLE_ID")));
        if (checkboxValue == null) checkboxValue = new ArrayList<>();
        List<String> finalCheckboxValue = checkboxValue;
        List<Article> articles = articlesPage.stream().filter(article -> article.hasRubrics(finalCheckboxValue)).collect(Collectors.toList());
        model.addAttribute("articles", articles);
        model.addAttribute("page", page);
        model.addAttribute("numbers", IntStream.range(0, articlesPage.getTotalPages()).toArray());
        model.addAttribute("checkboxOn", checkboxValue);
        List<String> rubrics2 = new ArrayList<>();
        loop:
        for (RubricModel rub : rubrics) {
                for (String name : checkboxValue) {
                    if ( rub.getRubricName().equals(name)) {
                        continue loop;
                    }
                }
            rubrics2.add(rub.getRubricName());
        }
        model.addAttribute("checkBoxOff", rubrics2);
        return "index";
    }

    @GetMapping("/")
    public String index_get (Model model,
                             @RequestParam(value = "page", required = false) Integer page) {
        if (page == null) { page = 0; }
        Page<Article> articlesPage = articlesService.getArticlePages(PageRequest.of(page, PAGE_SIZE, Sort.by(Sort.Direction.DESC, "ARTICLE_ID")));
        model.addAttribute("articles", articlesPage.getContent());
        model.addAttribute("page", page);
        model.addAttribute("numbers", IntStream.range(0, articlesPage.getTotalPages()).toArray());
        List<RubricModel> rubrics = rubricsService.getRubrics();
        model.addAttribute("checkBoxOff", rubrics.stream()
                .map(RubricModel::getRubricName)
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping(value = {"/article/{id}"})
    public String article(@PathVariable Long id, Model model) {
        ArticleFull article = articlesService.getArticleById(id);
        model.addAttribute("article", article);
        return "article";
    }

    @PostMapping("/delete_article")
    @PreAuthorize("hasAuthority('admin:delete_article')")
    public String deleteById ( @RequestParam(value = "id", required = false)Long id, Model model) {
        model.addAttribute("id", id);
        return "delete";
    }


}
