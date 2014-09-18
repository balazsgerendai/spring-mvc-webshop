package com.epam.jjp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "sellerUsername")
    private String sellerUsername;

    //    @Column(name = "buyerUsername")
    //    private String buyerUsername;
    //    
    @OneToOne
    @JoinColumn(name = "itemId")
    private Item item;
    
   
    @ManyToOne
    @JoinColumn(name = "buyerUsername")
    private Customer customer;

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

    public Long getItemId() {
        return item.getId();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}
