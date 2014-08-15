package com.epam.jjp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Customer;


@Repository("usersRepository")
public interface UserRepository extends JpaRepository<Customer, String>{
    
    Customer findByUsername(String username);
}
