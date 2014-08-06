package com.epam.jjp.service;

import com.epam.jjp.model.Items;
import com.epam.jjp.model.Sales;

public interface SalesService {
    Sales save(Sales sales);
    Sales find(Long id);
}
