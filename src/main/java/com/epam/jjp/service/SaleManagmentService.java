package com.epam.jjp.service;

import java.util.List;

import com.epam.jjp.model.Items;
import com.epam.jjp.model.Sales;

public interface SaleManagmentService {
    Items saveItem(Items item);
    Sales saveSale(Sales sale);
    void deleteItem(Items item);
    void deleteSale(Sales sale);
    
    Items findItem(Long id);
    Sales findSale(Long id);
    List<Items> findAllItems();
    List<Sales> findAllSales();
    
}
