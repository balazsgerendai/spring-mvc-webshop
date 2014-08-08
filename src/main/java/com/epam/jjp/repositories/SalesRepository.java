package com.epam.jjp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Sale;

@Repository("salesRepository")
public interface SalesRepository extends JpaRepository<Sale, Long>{
    
}
