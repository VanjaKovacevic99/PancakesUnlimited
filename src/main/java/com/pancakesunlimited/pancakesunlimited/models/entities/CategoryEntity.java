package com.pancakesunlimited.pancakesunlimited.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "categoryBy")
    @JsonIgnore
    private List<IngredientEntity> ingredientsBy;
    @OneToMany(mappedBy = "categoryBy")
    @JsonIgnore
    private List<IngredientEntity> ingredientsById;

}
