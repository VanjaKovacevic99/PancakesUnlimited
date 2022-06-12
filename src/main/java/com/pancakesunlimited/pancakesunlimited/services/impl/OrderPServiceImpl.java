package com.pancakesunlimited.pancakesunlimited.services.impl;

import com.pancakesunlimited.pancakesunlimited.exceptions.NotFoundException;
import com.pancakesunlimited.pancakesunlimited.models.dto.Ingredient;
import com.pancakesunlimited.pancakesunlimited.models.dto.OrderP;
import com.pancakesunlimited.pancakesunlimited.models.entities.OrderPEntity;
import com.pancakesunlimited.pancakesunlimited.models.requests.OrderPRequest;
import com.pancakesunlimited.pancakesunlimited.models.requests.PancakeAndPancakeIngredientRequest;
import com.pancakesunlimited.pancakesunlimited.repositories.OrderPEntityRepository;
import com.pancakesunlimited.pancakesunlimited.services.OrderPService;
import com.pancakesunlimited.pancakesunlimited.services.PancakeAndPancakeIngredientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderPServiceImpl implements OrderPService {

    private final ModelMapper modelMapper;

    private final OrderPEntityRepository orderPEntityRepository;
    private final PancakeAndPancakeIngredientService pancakeAndPancakeIngredientService;

    public OrderPServiceImpl(ModelMapper modelMapper, OrderPEntityRepository orderPEntityRepository, PancakeAndPancakeIngredientService pancakeAndPancakeIngredientService) {
        this.modelMapper = modelMapper;
        this.orderPEntityRepository = orderPEntityRepository;
        this.pancakeAndPancakeIngredientService = pancakeAndPancakeIngredientService;
    }

    @Override
    public void insert(OrderPRequest orderPRequest) throws NotFoundException {
        OrderPEntity orderPEntity=modelMapper.map(orderPRequest, OrderPEntity.class);
        orderPEntityRepository.saveAndFlush(orderPEntity);

    }

    @Override
    public OrderP findById(Integer id) throws NotFoundException {
        return modelMapper.map(orderPEntityRepository.findById(id).orElseThrow(NotFoundException::new),OrderP.class);

    }
}
