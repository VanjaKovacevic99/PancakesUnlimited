package com.pancakesunlimited.pancakesunlimited.models.requests;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PancakeAndPancakeIngredientRequest {
    @NotNull
    private List<Integer> list;
}
