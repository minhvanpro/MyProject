package com.example.news.services;

import com.example.news.dtos.CategoryDto;

import java.util.List;

public interface ICategoryService {
    CategoryDto create(CategoryDto dto);
    CategoryDto getById(Long id);

    List<CategoryDto> getAll();
}
