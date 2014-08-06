package com.epam.jjp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.User;


@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<User, String>{
    
    User findByUsername(String username);
    
}
