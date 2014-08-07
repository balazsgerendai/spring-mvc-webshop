package com.epam.jjp.service;

import com.epam.jjp.model.Customer;

public interface UsersService {
    Customer save(Customer user);
    Customer find(String username);
}
