/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schwit.example.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.schwit.example.web.service.CardValidation;

/**
 *
 * @author scja0
 */
@RestController
public class ClassController {
    
    private final CardValidation cardValidation;
    
    @Autowired
    public ClassController(CardValidation cardValidation) {
        this.cardValidation = cardValidation;
    }
    
    @GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
    
    @GetMapping("/cards/numbers/{number}")
    public String validNumber(@PathVariable(value="number") String number) {
    	if( !StringUtils.isNumeric(number)) return "/error";
    	return cardValidation.isValid(number) ? "True" : "False";
    }
    
    
}
