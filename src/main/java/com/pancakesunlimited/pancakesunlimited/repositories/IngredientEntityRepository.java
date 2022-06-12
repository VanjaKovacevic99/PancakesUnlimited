package com.pancakesunlimited.pancakesunlimited.repositories;

import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.entities.IngredientEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IngredientEntityRepository extends JpaRepository<IngredientEntity, Integer> {

    @Query("SELECT i FROM IngredientEntity i LEFT JOIN i.pancakeIngredientsBy a WHERE a.id.pancakeId=:id")
    List<IngredientEntity> getAllByPancakeId(Integer id);

}
