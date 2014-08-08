package com.epam.jjp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Items;
@Repository("itemsRepository")
public interface ItemsRepository extends JpaRepository<Items, Long>{
    
    Page<Items> findByNameOrderByExpirationDateDesc(Pageable pageable);
    
}
