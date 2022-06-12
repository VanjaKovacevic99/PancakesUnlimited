package com.pancakesunlimited.pancakesunlimited.controllers;


import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;
import com.pancakesunlimited.pancakesunlimited.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }



    @GetMapping
    public List<Ingredient> findAll(){
        return ingredientService.findAll();
    }

    @GetMapping("/{id}")
    public Ingredient findById(@PathVariable Integer id) throws NotFoundException {
        return ingredientService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        ingredientService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient insert(@RequestBody IngredientRequest ingredientRequest) throws NotFoundException {
        return ingredientService.insert(ingredientRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Ingredient update(@PathVariable Integer id,@RequestBody IngredientRequest ingredientRequest) throws NotFoundException {
        return  ingredientService.update(id,ingredientRequest);
    }


}
