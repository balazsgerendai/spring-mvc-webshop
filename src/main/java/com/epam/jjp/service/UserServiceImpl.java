package com.epam.jjp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.User;
import com.epam.jjp.repositories.UsersRepository;

@Service("usersService")
public class UserServiceImpl implements UsersService{
    @Autowired
    private UsersRepository usersRepository;
    
    @Override
    public User find(String username) {
        return usersRepository.findOne(username);
    }

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }

}
