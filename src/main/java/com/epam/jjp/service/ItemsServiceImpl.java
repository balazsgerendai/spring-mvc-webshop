package com.epam.jjp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.Items;
import com.epam.jjp.repositories.ItemsRepository;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService{
    @Autowired
    private ItemsRepository itemsRepository;
    
    @Override
    public Items save(Items items) {
        return itemsRepository.save(items);
    }

    @Override
    public Items find(Long id) {
        return itemsRepository.findOne(id);
    }

}
