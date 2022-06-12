package com.pancakesunlimited.pancakesunlimited.models.requests;

import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientKey;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PancakeIngredientRequest {
    @NotNull
    private PancakeIngredientKey id;
    @NotNull
    private Integer pancakeId;
    @NotNull
    private Integer ingredientId;

}
