package com.pancakesunlimited.pancakesunlimited.controllers;

import com.pancakesunlimited.pancakesunlimited.models.entities.CategoryEntity;
import com.pancakesunlimited.pancakesunlimited.repositories.CategoryEntityRepository;
//import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryEntityRepository repository;

    public CategoryController(CategoryEntityRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    List<CategoryEntity> findall(){
        return repository.findAll();
    }
}
