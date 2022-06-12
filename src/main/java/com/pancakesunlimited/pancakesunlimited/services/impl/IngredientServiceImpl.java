package com.pancakesunlimited.pancakesunlimited.services.impl;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.entities.CategoryEntity;
import com.pancakesunlimited.pancakesunlimited.models.entities.IngredientEntity;
import com.pancakesunlimited.pancakesunlimited.models.requests.IngredientRequest;
import com.pancakesunlimited.pancakesunlimited.repositories.CategoryEntityRepository;
import com.pancakesunlimited.pancakesunlimited.repositories.IngredientEntityRepository;
import com.pancakesunlimited.pancakesunlimited.services.IngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
    private final ModelMapper modelMapper;
    private final IngredientEntityRepository ingredientEntityRepository;
    private final CategoryEntityRepository categoryEntityRepository;


    @PersistenceContext
    private EntityManager entityManager;

    public IngredientServiceImpl(IngredientEntityRepository repository, ModelMapper modelMapper, CategoryEntityRepository categoryEntityRepository) {
        this.ingredientEntityRepository = repository;
        this.modelMapper = modelMapper;
        this.categoryEntityRepository = categoryEntityRepository;
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredientEntityRepository.findAll().stream().map(l-> modelMapper.map(l,Ingredient.class)).collect(Collectors.toList());
    }

    @Override
    public Ingredient findById(Integer id) throws NotFoundException {
        return modelMapper.map(ingredientEntityRepository.findById(id).orElseThrow(NotFoundException::new),Ingredient.class);
    }

    @Override
    public Ingredient insert(IngredientRequest ingredientRequest) throws NotFoundException {
        IngredientEntity ingredientEntity=modelMapper.map(ingredientRequest,IngredientEntity.class);
        CategoryEntity categoryEntity=categoryEntityRepository.findById(ingredientRequest.getCategoryId()).orElseThrow();
        ingredientEntity.setCategoryBy(categoryEntity);
        ingredientEntity.setId(null);
        ingredientEntity=ingredientEntityRepository.saveAndFlush(ingredientEntity);
        entityManager.refresh(ingredientEntity);
        return findById(ingredientEntity.getId());

    }

    @Override
    public Ingredient update(Integer id,IngredientRequest ingredientRequest) throws NotFoundException {
        IngredientEntity ingredientEntity=ingredientEntityRepository.findById(id).orElseThrow();
        ingredientEntity.setName(ingredientRequest.getName());
        ingredientEntity.setPrice(ingredientRequest.getPrice());
        CategoryEntity categoryEntity=categoryEntityRepository.findById(ingredientRequest.getCategoryId()).orElseThrow();
        ingredientEntity.setCategoryBy(categoryEntity);
        ingredientEntity=ingredientEntityRepository.saveAndFlush(ingredientEntity);
        entityManager.refresh(ingredientEntity);
        return findById(ingredientEntity.getId());
    }

    @Override
    public void delete(Integer id) {
        ingredientEntityRepository.deleteById(id);
    }


}
