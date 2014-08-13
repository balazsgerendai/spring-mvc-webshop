package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.Customer;
import com.epam.jjp.model.Item;
import com.epam.jjp.model.Sale;
import com.epam.jjp.repositories.ItemsRepository;
import com.epam.jjp.repositories.SalesRepository;
@Service("saleManagmentService")
public class SaleManagmentServiceImpl implements SaleManagmentService {
    
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    SalesRepository salesRepository;

    @Override
    public Item saveItem(Item item) {
        return itemsRepository.saveAndFlush(item);
    }

    @Override
    public Sale saveSale(Sale sale) {
        return salesRepository.saveAndFlush(sale);
    }

    @Override
    public void deleteItem(Item item) {
        itemsRepository.delete(item);
    }

    @Override
    public void deleteSale(Sale sale) {
        salesRepository.delete(sale);
    }
    
    @Override
    public Item findItem(Long id) {
        return itemsRepository.findOne(id);
    }

    @Override
    public Sale findSale(Long id) {
        return salesRepository.findOne(id);
    }

    @Override
    public List<Item> findAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public List<Sale> findAllSales() {
        return salesRepository.findAll();
    }

    public Page<Item> getItems(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        
        return itemsRepository.findItemsThatAreNotTheCurrentLoggedInUsers(user,request);
    }

    @Override
    public Long countItems() {
        return itemsRepository.count();
    }

    @Override
    public Long countSales() {
        return salesRepository.count();
    }
}
