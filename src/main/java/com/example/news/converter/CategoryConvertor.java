package com.example.news.converter;

import com.example.news.dtos.CategoryDto;
import com.example.news.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConvertor {
    public CategoryEntity toEntity(CategoryDto dto){
        CategoryEntity entity = new CategoryEntity();

        entity.setId(dto.getId());

        entity.setName(dto.getName());

        entity.setCode(dto.getCode());

        return entity;
    }

    public CategoryDto toDto(CategoryEntity entity){
        CategoryDto dto = new CategoryDto();

        dto.setId(entity.getId());

        dto.setName(entity.getName());

        dto.setCode(entity.getCode());

        return dto;
    }
}
