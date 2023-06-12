package com.example.news.services.impl;

import com.example.news.converter.ArticleConverter;
import com.example.news.dtos.ArticleDto;
import com.example.news.entities.ArticleEntity;
import com.example.news.repositories.IArticleRepository;
import com.example.news.repositories.ICategoryRepository;
import com.example.news.services.IArticleService;
import com.example.news.utils.ConstantUtils;
import com.example.news.utils.Utils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class ArticleService implements IArticleService {

    @Autowired
    private IArticleRepository iArticleRepository;

    @Autowired
    private ArticleConverter articleConverter;

    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Override
    public ArticleDto create(ArticleDto dto) {

        ArticleEntity entity = articleConverter.toEntity(dto);

        entity.setStatus(ConstantUtils.STATUS_ON);
        entity.setCreatDate(new Date(System.currentTimeMillis()));
        entity.setCode(Utils.generateCode(entity.getTitle()));
        entity.setCategory(
                iCategoryRepository.findById(dto.getCategory().getId()).get()
        );
        return articleConverter.toDto(iArticleRepository.save(entity));
    }
}
