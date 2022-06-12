package com.pancakesunlimited.pancakesunlimited.controllers;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.OrderP;
import com.pancakesunlimited.pancakesunlimited.models.entities.OrderPEntity;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.OrderPRequest;
import com.pancakesunlimited.pancakesunlimited.services.OrderPService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@Data
public class OrderPController {

    private final OrderPService orderPService;

    public OrderPController(OrderPService orderPService) {
        this.orderPService = orderPService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody OrderPRequest orderPRequest) throws NotFoundException {
         orderPService.insert(orderPRequest);
    }

    @GetMapping("/{id}")
    OrderP getOrderById(@PathVariable Integer id) throws NotFoundException {
        return orderPService.findById(id);
    }

}
