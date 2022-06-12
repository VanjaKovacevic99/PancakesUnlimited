package com.pancakesunlimited.pancakesunlimited.services.impl;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.repositories.IngredientEntityRepository;
import com.pancakesunlimited.pancakesunlimited.repositories.PancakeEntityRepository;
import com.pancakesunlimited.pancakesunlimited.services.PancakeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PancakeServiceImpl implements PancakeService {
    private final ModelMapper modelMapper;
    private final PancakeEntityRepository repository;

    private final IngredientEntityRepository ingredientEntityRepository;

    public PancakeServiceImpl(ModelMapper modelMapper, PancakeEntityRepository repository, IngredientEntityRepository ingredientEntityRepository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
        this.ingredientEntityRepository = ingredientEntityRepository;
    }


    @Override
    public List<Ingredient> findIngredientsById(Integer id) throws NotFoundException {

        return ingredientEntityRepository.getAllByPancakeId(id).stream().map(l-> modelMapper.map(l,Ingredient.class)).collect(Collectors.toList());

    }


}
