package com.example.news.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "n_article")
@Getter
@Setter
@NoArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
//    Generated from title
    private String code;

    private String content;

    private String description;

    private Date creatDate;

    private Date modifyDate;

    private int status;

    @OneToOne
    private CategoryEntity category;

}
