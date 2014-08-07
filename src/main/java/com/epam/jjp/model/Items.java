package com.epam.jjp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Items {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "sellerUsername")
    private String sellerUsername;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;
    
    @Column(name="expirationDate")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name="sellerUsername", insertable = false, updatable = false)
    private Customer users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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
    
    public Customer getUsers() {
        return users;
    }
    
    public void setUsers(Customer users) {
        this.users = users;
    }
}
