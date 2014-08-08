package com.epam.jjp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.model.Items;
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
 
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String sales(Model model) {
        
        return "sales";
    }
    
    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public String getItemPage(@PathVariable Integer pageNumber, Model model) {
        Page<Items> page = saleManagmentService.getItems(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("content", page.getContent());
        return "salesList";
    }

}
