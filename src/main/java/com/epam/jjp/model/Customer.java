package com.epam.jjp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class Customer implements UserDetails {

    private static final long serialVersionUID = -7060154441729348386L;

    @Id
    private String username;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "budget")
    private int budget;

    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Sales> sales = new ArrayList<Sales>();
    
    @OneToMany(mappedBy = "users",fetch = FetchType.EAGER)
    private List<Items> items = new ArrayList<Items>();
    
    @Column(name="enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    private List<Authorities> entityAuthorities = new ArrayList<Authorities>();

    
    @Transient private Set<GrantedAuthority> authorities;
    @Transient private boolean accountNonExpired;
    @Transient private boolean accountNonLocked;
    @Transient private boolean credentialsNonExpired;

    
    public List<Items> getItems() {
        return items;
    }
    
    public void setItems(List<Items> items) {
        this.items = items;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public List<Authorities> getEntityAuthorities() {
        return entityAuthorities;
    }

    public void setEntityAuthorities(List<Authorities> entityAuthorities) {
        this.entityAuthorities = entityAuthorities;
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


    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }


    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }


    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }


    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }


    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public void setAuthorities(Set<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    
}
