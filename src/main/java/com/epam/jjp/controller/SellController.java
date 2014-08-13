package com.epam.jjp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.model.Customer;
import com.epam.jjp.model.Item;
import com.epam.jjp.service.SaleManagmentService;
import com.epam.jjp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/sell")
public class SellController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellController.class);

    @Autowired
    private SaleManagmentService saleManagmentService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String sell(Model model) {
        model.addAttribute("itemForm", new Item());
        return "sell";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processSale(@Valid @ModelAttribute("itemForm") Item item, BindingResult result, Model model) {
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
}
