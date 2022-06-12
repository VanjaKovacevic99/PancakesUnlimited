package com.pancakesunlimited.pancakesunlimited.repositories;

import com.pancakesunlimited.pancakesunlimited.models.entities.OrderPEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.PancakeIngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderPEntityRepository extends JpaRepository<OrderPEntity,Integer> {
    @Query("SELECT pi FROM PancakeEntity pi where pi.orderPByOrderId.id= :id")
    List<OrderPEntity> getByPancakeOrderId(Integer id);
}
