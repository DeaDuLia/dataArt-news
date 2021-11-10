package com.dataart.javaschool.newsportal.controller;

import com.dataart.javaschool.newsportal.model.ArticleAndRubric;
import com.dataart.javaschool.newsportal.model.RubricModel;
import com.dataart.javaschool.newsportal.service.ArticlesService;
import com.dataart.javaschool.newsportal.service.RubricsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final ArticlesService articlesService;
    private final RubricsService rubricsService;

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/";
    }

    @GetMapping("/success")
    public String success () {
        return "redirect:/";
    }

}
