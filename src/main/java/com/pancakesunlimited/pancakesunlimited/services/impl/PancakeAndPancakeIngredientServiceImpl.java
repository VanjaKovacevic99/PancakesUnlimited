package com.pancakesunlimited.pancakesunlimited.services.impl;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Pancake;
import com.pancakesunlimited.pancakesunlimited.models.dto.PancakeIngredient;
import com.pancakesunlimited.pancakesunlimited.models.entities.*;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeAndPancakeIngredientRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeIngredientRequest;
import com.pancakesunlimited.pancakesunlimited.repositories.IngredientEntityRepository;
import com.pancakesunlimited.pancakesunlimited.repositories.PancakeEntityRepository;
import com.pancakesunlimited.pancakesunlimited.repositories.PancakeIngredientEntityRepository;
import com.pancakesunlimited.pancakesunlimited.services.PancakeAndPancakeIngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PancakeAndPancakeIngredientServiceImpl implements PancakeAndPancakeIngredientService {

    private final PancakeEntityRepository pancakeEntityRepository;
    private final PancakeIngredientEntityRepository pancakeIngredientEntityRepository;
    private final IngredientEntityRepository ingredientEntityRepository;

    public PancakeAndPancakeIngredientServiceImpl( PancakeEntityRepository pancakeEntityRepository, PancakeIngredientEntityRepository pancakeIngredientEntityRepository, IngredientEntityRepository ingredientEntityRepository) {
        this.pancakeEntityRepository = pancakeEntityRepository;
        this.pancakeIngredientEntityRepository = pancakeIngredientEntityRepository;
        this.ingredientEntityRepository = ingredientEntityRepository;
    }


    @Override
    public void insert(PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException {
        PancakeEntity pancakeEntity=new PancakeEntity();
        pancakeEntity.setId(null);
        pancakeEntity=pancakeEntityRepository.saveAndFlush(pancakeEntity);
        List<PancakeIngredientEntity> pancakeIngredientEntityArrayList=new ArrayList<>();

        addIngredientToPancake(pancakeAndPancakeIngredientRequest, pancakeEntity, pancakeIngredientEntityArrayList);

    }

    @Override
    public void update(Integer id,PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest) throws NotFoundException {
        PancakeEntity pancakeEntity=pancakeEntityRepository.findById(id).orElseThrow();
        List<PancakeIngredientEntity> pancakeIngredientList=pancakeIngredientEntityRepository.getByPancakeId(id);
        for (int i=0;i<pancakeIngredientList.size();i++) {
            pancakeIngredientEntityRepository.delete(pancakeIngredientList.get(i));
        }

        addIngredientToPancake(pancakeAndPancakeIngredientRequest, pancakeEntity, pancakeIngredientList);


    }

    public void addIngredientToPancake(PancakeAndPancakeIngredientRequest pancakeAndPancakeIngredientRequest, PancakeEntity pancakeEntity, List<PancakeIngredientEntity> pancakeIngredientList) {
        for (int i=0; i<pancakeAndPancakeIngredientRequest.getList().size();i++){
            PancakeIngredientEntity pancakeIngredientEntity =new PancakeIngredientEntity();
            pancakeIngredientEntity.setId(new PancakeIngredientKey(pancakeEntity.getId(),pancakeAndPancakeIngredientRequest.getList().get(i)));
            IngredientEntity ingredientEntity=ingredientEntityRepository.findById(pancakeAndPancakeIngredientRequest.getList().get(i)).orElseThrow();
            pancakeIngredientEntity.setPancakeBy(pancakeEntity);
            pancakeIngredientEntity.setIngredientBy(ingredientEntity);
            pancakeIngredientList.add(pancakeIngredientEntity);}
        pancakeIngredientEntityRepository.saveAllAndFlush(pancakeIngredientList);
    }

    @Override
    public void delete(Integer id) {
        List<PancakeIngredientEntity> pancakeIngredientList=pancakeIngredientEntityRepository.getByPancakeId(id);
        for (int i=0;i<pancakeIngredientList.size();i++) {
            pancakeIngredientEntityRepository.delete(pancakeIngredientList.get(i));
        }
        pancakeEntityRepository.deleteById(id);
    }

}








