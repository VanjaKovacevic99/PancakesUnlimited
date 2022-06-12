package com.pancakesunlimited.pancakesunlimited.models.dto;

import lombok.Data;


import java.io.Serializable;
import java.util.List;

@Data
public class OrderP implements Serializable {

    private Integer id;
    private String description;
    private String time;
    private List<Pancake> pancakes;
    private List<Ingredient> ingredients;

}
