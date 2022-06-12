package com.pancakesunlimited.pancakesunlimited.repositories;

import com.pancakesunlimited.pancakesunlimited.models.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity,Integer> {
}
