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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class Customer implements UserDetails {

    private static final long serialVersionUID = -7060154441729348386L;
    
    @Id
    @NotNull(message = "Username can't be Null")
    @NotBlank(message = "Username can't be blank")
    private String username;
    
    @NotNull(message = " Password can't be Null")
    @NotBlank(message = "Password can't be Blank")
    @Column(name = "password")
    private String password;
    
    @NotNull(message = "Budget can't be Null")
    @Min(value=0, message="Budget must be bigger than 0")
    @Column(name = "budget")
    private Integer budget;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Sale> sales = new ArrayList<Sale>();
    
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<Item>();
    
    @Column(name="enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Authorities> entityAuthorities = new ArrayList<Authorities>();

    
    @Transient private Set<GrantedAuthority> authorities;
    @Transient private boolean accountNonExpired;
    @Transient private boolean accountNonLocked;
    @Transient private boolean credentialsNonExpired;

    
    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Authorities> getEntityAuthorities() {
        return entityAuthorities;
    }

    public void setEntityAuthorities(List<Authorities> entityAuthorities) {
        this.entityAuthorities = entityAuthorities;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
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
