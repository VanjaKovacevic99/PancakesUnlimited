package com.pancakesunlimited.pancakesunlimited.models.dto;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
public class OrderP {

    private Integer id;
    private String description;
    private String time;
    private List<Pancake> pancakes;
    private List<Ingredient> ingredients;

}
