package com.epam.jjp.service;

import com.epam.jjp.model.User;

public interface UsersService {
    User save(User user);
    User find(String username);
}
