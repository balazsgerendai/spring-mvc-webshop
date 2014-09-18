package com.epam.jjp.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.model.Authorities;
import com.epam.jjp.model.Customer;
import com.epam.jjp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profileSoldItems(Locale locale, Model model, String userName) {

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Customer customer = userService.find(username);
        model.addAttribute("sales", customer.getSales());

        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("userForm", new Customer());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid @ModelAttribute("userForm") Customer customer, BindingResult result, Model model) {
        if(userService.exists(customer.getUsername())){
            result.addError(new ObjectError("duplicateEntry", "Duplicate entry"));
        }
        
        if(result.hasErrors()){
            model.addAttribute("status",result);
        }else{
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setAccountNonExpired(true);
            customer.setAccountNonLocked(true);
            customer.setEnabled(true);
            customer.setCredentialsNonExpired(true);
            customer.setUsername(customer.getUsername().toLowerCase());
            customer.setPassword(hashedPassword);
            Authorities auth = new Authorities();
            
            auth.setAuthority("ROLE_USER");
            auth.setUsername(customer.getUsername().toLowerCase());
            
            userService.save(customer);
            userService.save(auth);
            model.addAttribute("save",true);
            return "redirect:/register";
        }
        return "register";
    }
}
