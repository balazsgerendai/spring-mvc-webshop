package com.epam.jjp.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.jjp.model.Items;
import com.epam.jjp.service.ItemsService;
import com.epam.jjp.service.UsersService;
  
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;
    @Autowired
    private UsersService usersService;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        //TEST
      System.out.println("asd");
      System.out.println(itemsService.find(1L).getName());
      for(Items item : usersService.find("balazs").getItems()){
          System.out.println(item.getDescription());
      }
    
        return "home";
    }

}
