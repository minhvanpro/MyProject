package com.example.news.converter;

import com.example.news.dtos.ArticleDto;
import com.example.news.entities.ArticleEntity;
import com.example.news.repositories.IArticleRepository;
import com.example.news.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ArticleConverter {
    @Autowired
    private CategoryConvertor categoryConvertor;
    public ArticleEntity toEntity(ArticleDto dto){
        ArticleEntity entity = new ArticleEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setCode(dto.getCode());
        entity.setContent(dto.getContent());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setCreatDate(dto.getCreatDate());
        entity.setModifyDate(dto.getModifyDate());
        entity.setCategory(categoryConvertor.toEntity(dto.getCategory()));


        return entity;
    }

    public ArticleDto toDto(ArticleEntity entity){
        ArticleDto dto = new ArticleDto();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setCode(entity.getCode());
        dto.setContent(entity.getContent());
        dto.setDescription(entity.getDescription());
        dto.setStatus(entity.getStatus());
        dto.setCreatDate(entity.getCreatDate());
        dto.setModifyDate(entity.getModifyDate());
        dto.setCategory(categoryConvertor.toDto(entity.getCategory()));


        return dto;
    }
}
