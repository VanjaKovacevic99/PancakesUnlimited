package com.pancakesunlimited.pancakesunlimited.services;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findById(Integer id) throws NotFoundException;

    Ingredient insert(IngredientRequest ingredientRequest) throws NotFoundException;

    Ingredient update(Integer id,IngredientRequest ingredientRequest) throws NotFoundException;
    void delete(Integer id);




}
