package com.dataart.javaschool.newsportal.controller;

import com.dataart.javaschool.newsportal.entity.Article;
import com.dataart.javaschool.newsportal.exception.FileNotFoundException;
import com.dataart.javaschool.newsportal.service.ArticlesService;
import com.dataart.javaschool.newsportal.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;
    private final ArticlesService articlesService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('user:create_article')")
    public String upload () {
        return "upload";
    }


    @PostMapping("/info")
    @PreAuthorize("hasAuthority('user:create_article')")
    public String uploadFile (@RequestParam(value = "file", required = false) MultipartFile file, Model model) throws IOException {
        if (file == null || file.getOriginalFilename() == null || file.getOriginalFilename().equals("")) throw new FileNotFoundException("Файл не найден");
        String filePath = fileUploadService.uploadFile(file);
        Article article = fileUploadService.doCalculationInZipFile(filePath);
        articlesService.insertArticle(article);
        model.addAttribute("message", "Файл успешно загружен!");
        model.addAttribute("name", "success");
        return "upload";
    }

}
