package com.pancakesunlimited.pancakesunlimited.controllers;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.Pancake;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeAndPancakeIngredientRequest;
import com.pancakesunlimited.pancakesunlimited.services.IngredientService;
import com.pancakesunlimited.pancakesunlimited.services.PancakeAndPancakeIngredientService;
import com.pancakesunlimited.pancakesunlimited.services.PancakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pancakes")
public class PancakeController {
    private final PancakeService service;
    private final IngredientService ingredientService;
    private final PancakeAndPancakeIngredientService pancakeAndPancakeIngredientService;

    public PancakeController(PancakeService service, IngredientService ingredientService, PancakeAndPancakeIngredientService pancakeAndPancakeIngredientService) {
        this.service = service;

        this.ingredientService = ingredientService;
        this.pancakeAndPancakeIngredientService = pancakeAndPancakeIngredientService;
    }



    @GetMapping("/{id}/ingredients")
   public List<Ingredient> getAllIngredientsInPancake(@PathVariable Integer id) throws NotFoundException {
        return service.findIngredientsById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException {
        pancakeAndPancakeIngredientService.insert(pancakeAndPancakeIngredientRequest);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        pancakeAndPancakeIngredientService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Integer id,@RequestBody PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException {
        pancakeAndPancakeIngredientService.update(id,pancakeAndPancakeIngredientRequest);
    }




}
