package com.epam.jjp.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.cypher.internal.compiler.v2_1.ast.rewriters.useAliasesInSortSkipAndLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.jjp.model.Authorities;
import com.epam.jjp.model.Customer;
import com.epam.jjp.repositories.UserRepository;

@Service("usersService")
public class UserServiceImpl implements UsersService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Customer find(String username) {
        return userRepository.findOne(username);
    }

    @Override
    public Customer save(Customer user) {
        return userRepository.save(user);
    }

    /**
    * Returns a populated {@link UserDetails} object.
    * The username is first retrieved from the database and then mapped to
    * a {@link UserDetails} object.
    */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Customer domainUser = userRepository.findOne(username);
        if(domainUser == null){
            throw new UsernameNotFoundException(username);
        }
        Customer result = new Customer();
       
        result.setUsername(domainUser.getUsername());
        result.setPassword(domainUser.getPassword().toLowerCase());
        result.setEnabled(true);
        result.setAccountNonExpired(true);
        result.setAccountNonLocked(true);
        result.setCredentialsNonExpired(true);
        result.setAuthorities(getGrantedAuthorities(domainUser.getEntityAuthorities()));
        result.setBudget(domainUser.getBudget());

        return result;
    }
    /**
    * Wraps {@link String} roles to {@link SimpleGrantedAuthority} objects
    * @param roles {@link String} of roles
    * @return list of granted authorities
    */
    public Set<GrantedAuthority> getGrantedAuthorities(List<Authorities> userAuthorities) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(Authorities authority : userAuthorities){
            authorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }
        return authorities;
    }
}
