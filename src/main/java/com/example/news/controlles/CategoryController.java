package com.example.news.controlles;

import com.example.news.dtos.CategoryDto;
import com.example.news.services.ICategoryService;
import com.example.news.common.FunctionCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryDto categoryDto){
        try {
            return ResponseEntity.ok(FunctionCommon.getResponseEntity(
                    HttpStatus.OK.value(),
                    iCategoryService.create(categoryDto),
                    true));

        }catch (Exception e){
            return ResponseEntity.ok(FunctionCommon.getResponseEntity(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Add failed data",
                    false));
        }
    }
    @GetMapping("/get/all")
    public ResponseEntity<?> getAll(){
        List<CategoryDto> listDto = iCategoryService.getAll();
        return ResponseEntity.ok(
                FunctionCommon.getResponseEntity(
                        HttpStatus.OK.value(),
                        listDto,
                        true
                )
                );
    }
    @GetMapping("/get/one/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        CategoryDto dto = iCategoryService.getById(id);
        if (dto != null) {
            return ResponseEntity.ok(
                    FunctionCommon.getResponseEntity(
                            HttpStatus.OK.value(),
                            dto,
                            true
                    )
            );
        }
        return ResponseEntity.ok(
                FunctionCommon.getResponseEntity(
                        HttpStatus.NOT_FOUND.value(),
                        "No category were found with id " + id,
                        false
                )
        );
    }
}
