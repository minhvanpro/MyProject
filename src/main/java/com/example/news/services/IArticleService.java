package com.example.news.services;

import com.example.news.dtos.ArticleDto;

public interface IArticleService {
    ArticleDto create(ArticleDto dto);
}
