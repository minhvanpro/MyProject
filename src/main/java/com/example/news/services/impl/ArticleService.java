package com.example.news.services.impl;

import com.example.news.converter.ArticleConverter;
import com.example.news.dtos.ArticleDto;
import com.example.news.entities.ArticleEntity;
import com.example.news.repositories.IArticleRepository;
import com.example.news.repositories.ICategoryRepository;
import com.example.news.searches.ArticleSearch;
import com.example.news.services.IArticleService;
import com.example.news.common.ConstantCommon;
import com.example.news.common.FunctionCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        entity.setStatus(ConstantCommon.STATUS_ON);
        entity.setCreatDate(new Date(System.currentTimeMillis()));
        entity.setCode(FunctionCommon.generateCode(entity.getTitle()));
        entity.setCategory(
                iCategoryRepository.findById(dto.getCategory().getId()).get()
        );
        entity = iArticleRepository.save(entity);
        ArticleDto resul = articleConverter.toDto(entity);
        return resul;
    }

    @Override
    public ArticleDto getById(Long id) {
        Optional<ArticleEntity>optionalArticleEntity=iArticleRepository.findById(id);

        if (optionalArticleEntity.isPresent()){
            return articleConverter.toDto(optionalArticleEntity.get());
        }
        return null;
    }

    @Override
    public List<ArticleDto> getAll() {
        List<ArticleEntity>listArticleEntity=iArticleRepository.findAll();
        List<ArticleDto>listArticleDto=new ArrayList<>();
        if (!listArticleEntity.isEmpty()){
            for (int i = 0; i < listArticleEntity.size();i++){
                listArticleDto.add(articleConverter.toDto(listArticleEntity.get(i)));
            }
            return listArticleDto;
        }
        return null;
    }

    @Override
    public List<ArticleDto> getAll(ArticleSearch articleSearch) {
        articleSearch.initializePageable();
        StringBuilder query = new StringBuilder("SELECT * FROM n_article AS a");
        if (!StringUtils.isEmpty(articleSearch.getTitle())){
            query.append(" WHERE a.title LIKE '%").append(articleSearch.getTitle()).append("%'");
            if (articleSearch.getCategoryId()!=null){
                query.append(" AND a.category_id = ").append(articleSearch.getCategoryId());
            }
        }else {
            if (articleSearch.getCategoryId()!=null){
                query.append(" WHERE a.category_id = ").append(articleSearch.getCategoryId());
            }
        }


        System.out.println(query.toString());

        return null;
    }

}
