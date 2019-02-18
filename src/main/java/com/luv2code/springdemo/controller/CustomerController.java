/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Wojtek
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private CustomerDAO customerDAO;
    
    @RequestMapping("/list")
    public String listCustomers(Model theModel)
    {
        // get customers from the dao
        List<Customer> theCustomers = customerDAO.getCustomers();
        
        // add the customers to the model
        theModel.addAttribute("customers", theCustomers);
        
        return "list-customers";
    }
    
    
}
