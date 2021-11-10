package com.dataart.javaschool.newsportal.service;

import com.dataart.javaschool.newsportal.entity.Article;
import com.dataart.javaschool.newsportal.exception.ArticleHasTwoLessLinesException;
import com.dataart.javaschool.newsportal.exception.FileIsNotZipException;
import com.dataart.javaschool.newsportal.exception.FileNotFoundException;
import com.dataart.javaschool.newsportal.exception.ZipFileHasOneMoreFileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

@Service
public class FileUploadService {

    public String uploadFile (MultipartFile file) throws IOException {
        String filePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath() + file.getOriginalFilename();
        file.transferTo(new File(filePath));
        return filePath;
    }

    public Article doCalculationInZipFile (String filePath)  {
        if (filePath == null) throw new FileNotFoundException("Файл по указанному пути не найден");
        if (!filePath.endsWith(".zip")) throw new FileIsNotZipException("Файл не является zip-архивом");
        int counter = 0;
        String header = "";
        String body = "";
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(filePath))) {
            StringBuilder bodyBuilder = new StringBuilder();
            while((zip.getNextEntry())!= null){
                if (counter > 0) {
                    throw new ZipFileHasOneMoreFileException("В архиве есть файлы помимо Article.txt");
                }
                counter++;
                Scanner in = new Scanner(zip);
                String text;
                int i = 0;
                while (in.hasNextLine()) {
                    text = in.nextLine();
                    if (i==0) {
                        header = text;
                    } else {
                        bodyBuilder.append(text).append("\n");
                    }
                    i++;
                }
            }
            body = bodyBuilder.toString();
        } catch(Exception e){ throw new RuntimeException(e.getMessage());}
        if (header.equals("") || body.equals("")) throw new ArticleHasTwoLessLinesException("В файле меньше двух строк");
        return new Article(header, body, "7-11-2021");
    }
}
