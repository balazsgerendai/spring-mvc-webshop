package com.epam.jjp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import com.epam.jjp.model.Item;
import com.epam.jjp.model.Sale;

public interface SaleManagmentService {
    Item saveItem(Item item);
    Sale saveSale(Sale sale);
    void deleteItem(Item item);
    void deleteSale(Sale sale);
    
    Long countItems();
    Long countSales();
    Item findItem(Long id);
    Sale findSale(Long id);
    List<Item> findAllItems();
    List<Sale> findAllSales();
    Page<Item> getItems(Integer pageNumber);
}
