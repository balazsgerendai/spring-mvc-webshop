package com.epam.jjp.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    
    @NotNull(message="Name can't be null!")
    @NotEmpty(message="Name can't be empty!")
    @Column(name = "name")
    private String name;
    
    @Column(name = "sellerUsername")
    private String sellerUsername;
    
    @NotNull(message="Description can't be null!")
    @NotEmpty(message="Description can't be empty!")
    @Column(name = "description")
    private String description;
    
    @NotNull(message="Price can't be null")
    @Min(value=0, message="Minimum price must be bigger than 0")
    @Column(name = "price")
    private Integer price;
    
    @NotNull (message="Expiration date can't be null")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name="expirationDate")
    private Date expirationDate;
    
    @Column(name="sold")
    private Boolean sold;
    
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }
    
}
