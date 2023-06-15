package com.example.news.searches;

import com.example.news.common.PageableCommon;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ArticleSearch {
    private String title;

    private Long CategoryId;

    private PageableCommon pageable;

    public void initializePageable(){
        if (pageable == null){
            pageable = new PageableCommon();
        }
        pageable.initialize();
    }
}
