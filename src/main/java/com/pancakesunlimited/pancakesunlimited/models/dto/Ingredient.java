package com.pancakesunlimited.pancakesunlimited.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pancakesunlimited.pancakesunlimited.models.entities.CategoryEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
public class Ingredient {

    private String name;
    private Double price;
    private Integer categoryId;
    private String categoryName;
}
