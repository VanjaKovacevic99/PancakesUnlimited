package com.pancakesunlimited.pancakesunlimited.repositories;

import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.Pancake;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PancakeEntityRepository extends JpaRepository<PancakeEntity,Integer> {

}
