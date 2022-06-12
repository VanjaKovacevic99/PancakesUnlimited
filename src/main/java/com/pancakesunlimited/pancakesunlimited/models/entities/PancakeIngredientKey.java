package com.pancakesunlimited.pancakesunlimited.models.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
@EqualsAndHashCode
public class PancakeIngredientKey implements Serializable {

   @Column(name = "pancake_id" )
   private Integer pancakeId;
   @Column(name = "ingredient_id" )
   private Integer ingredientId;

    public PancakeIngredientKey(){}
    public PancakeIngredientKey(Integer pancakeId, Integer ingredientId) {
        this.pancakeId=pancakeId;
        this.ingredientId=ingredientId;
    }
}
