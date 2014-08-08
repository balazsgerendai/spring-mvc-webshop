package com.epam.jjp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.Items;
import com.epam.jjp.model.Sales;
import com.epam.jjp.repositories.ItemsRepository;
import com.epam.jjp.repositories.SalesRepository;
@Service("saleManagmentService")
public class SaleManagmentServiceImpl implements SaleManagmentService {
    
    @Autowired
    ItemsRepository itemsRepository;
    @Autowired
    SalesRepository salesRepository;

    @Override
    public Items saveItem(Items item) {
        return itemsRepository.save(item);
    }

    @Override
    public Sales saveSale(Sales sale) {
        return salesRepository.save(sale);
    }

    @Override
    public void deleteItem(Items item) {
        itemsRepository.delete(item);
    }

    @Override
    public void deleteSale(Sales sale) {
        salesRepository.delete(sale);
    }

    @Override
    public Items findItem(Long id) {
        return itemsRepository.findOne(id);
    }

    @Override
    public Sales findSale(Long id) {
        return salesRepository.findOne(id);
    }

    @Override
    public List<Items> findAllItems() {
        return itemsRepository.findAll();
    }

    @Override
    public List<Sales> findAllSales() {
        return salesRepository.findAll();
    }

    public Page<Items> getItems(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
        return itemsRepository.findAll(request);
    }
}
