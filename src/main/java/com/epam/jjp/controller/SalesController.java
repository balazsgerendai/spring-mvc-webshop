package com.epam.jjp.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jjp.model.Customer;
import com.epam.jjp.model.Item;
import com.epam.jjp.model.Sale;
import com.epam.jjp.service.SaleManagmentService;
import com.epam.jjp.service.UserService;
import com.epam.jjp.simpleClasses.SimpleSale;

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
    
    private Mapper doserMapper = new DozerBeanMapper();
    
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
        model.addAttribute("loggedInUser", (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "salesList";
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.POST, produces="application/json")
    @ResponseBody public String buyItem(@PathVariable Long id) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
      
        Customer buyer = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Item sellingItem = saleManagmentService.findItem(id);
        Customer seller = sellingItem.getCustomer();
        if(buyer.getBudget() < sellingItem.getPrice()){
            return "{\"status\":\"not enough money\"}";
        }
        Sale sale = new Sale();
        sale.setItem(sellingItem);
        sale.setSellerUsername(sellingItem.getCustomer().getUsername());

        sale.setCustomer(buyer);
        
        sellingItem.setSold(true);
        seller.setBudget(seller.getBudget() + sellingItem.getPrice());
        buyer.setBudget(buyer.getBudget() - sellingItem.getPrice());
        
        saleManagmentService.saveSale(sale);
        saleManagmentService.saveItem(sellingItem);
        userService.save(buyer);
        userService.save(seller);
        
        return mapper.writeValueAsString(doserMapper.map(sale, SimpleSale.class));
    }
    

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editItem(@PathVariable Long id, Model model) {
        Item item = saleManagmentService.findItem(id);
        model.addAttribute("itemForm", item);
        return "sell";
    }
    
    @PreAuthorize ("#item.sellerUsername == authentication.principal.username")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String processItem(@Valid @ModelAttribute("itemForm") Item item, BindingResult result, Model model) {
       if(!result.hasErrors()){
           Customer sellerUser = (Customer)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         
           item.setCustomer(sellerUser);
           item.setSold(false);
           saleManagmentService.saveItem(item);
          model.addAttribute("save", true);
       }
        model.addAttribute("status", result);
        return "sell";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST, produces="application/json")
    @ResponseBody public String deleteItem(@PathVariable Long id) throws JsonGenerationException, JsonMappingException, IOException {
       Item item = saleManagmentService.findItem(id);
       saleManagmentService.deleteItem(item);
       return "{\"status\":\"OK\"}";
    }
}
