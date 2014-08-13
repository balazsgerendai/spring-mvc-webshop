package com.epam.jjp.service;

import com.epam.jjp.model.Authorities;
import com.epam.jjp.model.Customer;

public interface UserService {
    Customer save(Customer user);
    Customer find(String username);
    Authorities save(Authorities auth);
}
