package com.epam.jjp.service;

import com.epam.jjp.model.Items;

public interface ItemsService {
    Items save(Items items);
    Items find(Long id);
}
