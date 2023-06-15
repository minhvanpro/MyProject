package com.example.news.services;

import com.example.news.dtos.ArticleDto;
import com.example.news.searches.ArticleSearch;

import java.util.List;

public interface IArticleService {
    ArticleDto create(ArticleDto dto);
    ArticleDto getById(Long id);

    List<ArticleDto> getAll();

    List<ArticleDto> getAll(ArticleSearch articleSearch);
}
