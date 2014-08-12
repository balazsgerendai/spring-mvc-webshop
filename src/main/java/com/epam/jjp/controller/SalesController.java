package com.epam.jjp.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jjp.model.Customer;
import com.epam.jjp.model.Item;
import com.epam.jjp.model.Sale;
import com.epam.jjp.service.SaleManagmentService;
import com.epam.jjp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sales")
public class SalesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    private SaleManagmentService saleManagmentService;

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public String getItemPage(@PathVariable Integer pageNumber, Model model) {
        Page<Item> page = saleManagmentService.getItems(pageNumber);

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

    @RequestMapping(value = "buy/{id}", method = RequestMethod.POST, produces="application/json")
    @ResponseBody public String buyItem(@PathVariable Long id) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
       
        Customer customer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Item sellingItem = saleManagmentService.findItem(id);
        if(customer.getBudget() < sellingItem.getPrice()){
            return "{\"status\":\"not enough money\"}";
        }
        Sale sale = new Sale();
        sale.setItemId(id);
        sale.setSellerUsername(sellingItem.getSellerUsername());
        sale.setCustomer(customer);
        
        sellingItem.setSold(true);
        
        customer.setBudget(customer.getBudget() - sellingItem.getPrice());
        
        saleManagmentService.saveSale(sale);
        saleManagmentService.saveItem(sellingItem);
        userService.save(customer);
        
        return mapper.writeValueAsString(sale);
    }
}
