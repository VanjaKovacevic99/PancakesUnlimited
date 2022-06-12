package com.pancakesunlimited.pancakesunlimited.services;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.PancakeIngredient;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeAndPancakeIngredientRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeIngredientRequest;

import java.util.List;

public interface PancakeAndPancakeIngredientService {
    void insert(PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException;

    void update(Integer id,PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException;
    void delete(Integer id);
}
