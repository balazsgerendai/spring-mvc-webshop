package com.epam.jjp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Sales;

@Repository("salesRepository")
public interface SalesRepository extends JpaRepository<Sales, Long>{
    
}
