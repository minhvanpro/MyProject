package com.example.news.dtos;

import com.example.news.entities.CategoryEntity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class ArticleDto {
    private Long id;

    private String title;
    //    Generated from title
    private String code;

    private String content;

    private String description;

    private Date creatDate;

    private Date modifyDate;

    private int status;

    private CategoryDto category;
}
