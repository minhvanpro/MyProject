package com.example.news.controlles;

import com.example.news.dtos.ArticleDto;
import com.example.news.repositories.IArticleRepository;
import com.example.news.services.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private IArticleService iArticleService;

    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok("Hello word");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ArticleDto articleDto){
        try{
            return ResponseEntity.ok(iArticleService.create(articleDto));
        }catch (Exception e){
            return ResponseEntity.status(400).body("Bad Request");
        }
    }
}
