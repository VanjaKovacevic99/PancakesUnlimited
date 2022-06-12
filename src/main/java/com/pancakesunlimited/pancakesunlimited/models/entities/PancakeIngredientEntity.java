package com.pancakesunlimited.pancakesunlimited.models.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity

@Table(name = "pancake_ingredient")
public class PancakeIngredientEntity implements Serializable  {
    @EmbeddedId
    PancakeIngredientKey id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("pancakeId")
    @JoinColumn(name = "pancake_id", referencedColumnName = "id", nullable = false)
    private PancakeEntity pancakeBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", nullable = false)
    private IngredientEntity ingredientBy;




}
