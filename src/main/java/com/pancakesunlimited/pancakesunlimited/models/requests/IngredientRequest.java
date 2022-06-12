package com.pancakesunlimited.pancakesunlimited.models.requests;

import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotBlank;

@Data
public class IngredientRequest {
    @NotBlank
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private Integer categoryId;

}
