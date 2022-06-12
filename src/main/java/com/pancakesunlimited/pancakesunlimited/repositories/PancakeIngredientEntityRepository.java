package com.pancakesunlimited.pancakesunlimited.repositories;

import com.pancakesunlimited.pancakesunlimited.models.dto.PancakeIngredient;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PancakeIngredientEntityRepository extends JpaRepository<PancakeIngredientEntity, PancakeIngredientKey> {
    @Query("SELECT pi FROM PancakeIngredientEntity pi where pi.pancakeBy.id= :id")
    List<PancakeIngredientEntity> getByPancakeId(Integer id);
}
