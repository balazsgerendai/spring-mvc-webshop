package com.epam.jjp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "sellerUsername")
    private String sellerUsername;

//    @Column(name = "buyerUsername")
//    private String buyerUsername;
//    
    @Column(name = "itemId")
    private int itemId;
    
    @ManyToOne
    @JoinColumn(name="buyerUsername")
    private Customer users;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Customer getUsers() {
        return users;
    }

    public void setUsers(Customer users) {
        this.users = users;
    }
    
    
    
}
