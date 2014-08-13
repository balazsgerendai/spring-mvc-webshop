package com.epam.jjp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.epam.jjp.model.Item;
@Repository("itemsRepository")
public interface ItemsRepository extends JpaRepository<Item, Long>{
    
    @Query("SELECT i FROM Item i WHERE sellerUsername NOT LIKE ?")
    Page<Item> findItemsThatAreNotTheCurrentLoggedInUsers(String username, Pageable pageable);
}
