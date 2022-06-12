package com.pancakesunlimited.pancakesunlimited.services;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;

import java.util.List;

public interface PancakeService {


    List<Ingredient> findIngredientsById(Integer id) throws NotFoundException;
}
