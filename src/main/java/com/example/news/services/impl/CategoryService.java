package com.example.news.services.impl;

import com.example.news.converter.CategoryConvertor;
import com.example.news.dtos.CategoryDto;
import com.example.news.entities.CategoryEntity;
import com.example.news.repositories.ICategoryRepository;
import com.example.news.services.ICategoryService;
import com.example.news.common.FunctionCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private CategoryConvertor categoryConvertor;
    @Override
    public CategoryDto create(CategoryDto dto) {
        CategoryEntity entity = categoryConvertor.toEntity(dto);
        entity.setCode(
                FunctionCommon.generateCode(entity.getName())
        );
        CategoryEntity result = iCategoryRepository.save(entity);
        CategoryDto categoryDto = categoryConvertor.toDto(result);
        return categoryDto;
    }

    @Override
    public CategoryDto getById(Long id){
        Optional<CategoryEntity> optionalCategoryEntity = iCategoryRepository.findById(id);
        if (optionalCategoryEntity.isPresent()){
            return categoryConvertor.toDto(optionalCategoryEntity.get());
        }
        return null;
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryEntity>listCategoryEntity = iCategoryRepository.findAll();
        List<CategoryDto>listCategoryDto = new ArrayList<>();
        if (!listCategoryEntity.isEmpty()){
            for (int i = 0; i < listCategoryEntity.size(); i++){
                listCategoryDto.add(categoryConvertor.toDto(listCategoryEntity.get(i)));
            }
            return listCategoryDto;
        }
        return null;
    }

}
