package com.epam.jjp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Authorities;
import com.epam.jjp.model.Customer;


@Repository("authoritiesRepository")
public interface AuthoritiesRepository extends JpaRepository<Authorities, String>{
    
}
