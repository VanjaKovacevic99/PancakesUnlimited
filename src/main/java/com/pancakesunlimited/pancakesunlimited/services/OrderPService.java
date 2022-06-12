package com.pancakesunlimited.pancakesunlimited.services;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.OrderP;
import com.pancakesunlimited.pancakesunlimited.models.entities.OrderPEntity;
import com.pancakesunlimited.pancakesunlimited.models.requests.OrderPRequest;

import java.util.List;

public interface OrderPService {
    void insert(OrderPRequest orderPRequest) throws NotFoundException;
     OrderP findById(Integer id) throws NotFoundException;
}
