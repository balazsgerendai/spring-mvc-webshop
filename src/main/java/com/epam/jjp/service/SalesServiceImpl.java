package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.Items;
import com.epam.jjp.model.Sales;
import com.epam.jjp.repositories.ItemsRepository;
import com.epam.jjp.repositories.SalesRepository;

@Service("salesService")
public class SalesServiceImpl implements SalesService{
    
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Sales save(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales find(Long id) {
        return salesRepository.findOne(id);
    }
}
