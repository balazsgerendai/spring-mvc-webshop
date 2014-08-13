package com.epam.jjp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epam.jjp.service.SaleManagmentService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
    
    @Autowired
    private SaleManagmentService saleManagmentService;
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpSession session) {

        return "home";
    }

    @RequestMapping(value = "/home/chart", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String chart(){
        Long itemCount = saleManagmentService.countItems();
        Long saleCount = saleManagmentService.countSales();

        return "{\"type\" : \"pie\",\"name\" : \"Sales and Items\",\"data\" : [[\"Items\","+itemCount+"],[  \"Sales\","+saleCount+"]]}";
    }
}
