package com.pancakesunlimited.pancakesunlimited.models.dto;

import com.pancakesunlimited.pancakesunlimited.models.entities.IngredientEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientKey;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PancakeIngredient {
    @NotNull
    private PancakeIngredientKey pancakeIngredientKey;


}
