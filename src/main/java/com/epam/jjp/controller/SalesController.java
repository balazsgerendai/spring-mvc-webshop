package com.epam.jjp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.service.SaleManagmentService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sales")
public class SalesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);
    
    @Autowired
    private SaleManagmentService saleManagmentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sales(Locale locale, Model model) {
        
        
        
        return "sales";
    }

}
