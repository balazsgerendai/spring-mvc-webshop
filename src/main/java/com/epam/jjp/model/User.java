package com.epam.jjp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String username;
    
    @Column(name = "budget")
    private int budget;

    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Sales> sales = new ArrayList<Sales>();
    
    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Items> items = new ArrayList<Items>();
    
    @Column(name="enabled")
    private boolean enabled;
    
    
    public List<Items> getItems() {
        return items;
    }
    
    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    
}
