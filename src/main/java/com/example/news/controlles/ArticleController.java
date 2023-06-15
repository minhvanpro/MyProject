package com.example.news.controlles;

import com.example.news.dtos.ArticleDto;
import com.example.news.searches.ArticleSearch;
import com.example.news.services.IArticleService;
import com.example.news.common.FunctionCommon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private IArticleService iArticleService;

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(@RequestParam("search") String search) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArticleSearch articleRequestModel = mapper.readValue(search,ArticleSearch.class);
        List<ArticleDto> listDto = iArticleService.getAll(articleRequestModel);
        return ResponseEntity.ok(
                FunctionCommon.getResponseEntity(
                        HttpStatus.OK.value(),
                        listDto,
                        true
                )
        );
    }


    @GetMapping("/get/one/{id}")
    public ResponseEntity<?> getById(@PathVariable(name="id") Long id){
        ArticleDto dto = iArticleService.getById(id);
        if (dto!=null){
            return ResponseEntity.ok(FunctionCommon.getResponseEntity(
                    HttpStatus.OK.value(),
                    dto,
                    true));
        }
        return ResponseEntity.ok(
                            FunctionCommon.getResponseEntity(
                                    HttpStatus.NOT_FOUND.value(),
                                    "No article were found with id"+id,
                                    false
                                                    )
                                );
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ArticleDto articleDto){
        try{
            return ResponseEntity.ok(
                    FunctionCommon.getResponseEntity(
                            HttpStatus.OK.value(),
                            iArticleService.create(articleDto),
                            true
                    )
            );
        }catch (Exception e){
            return ResponseEntity.ok(
                    FunctionCommon.getResponseEntity(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            "Add failed data",
                            false
                    )
            );
        }
    }
}
