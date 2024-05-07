/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.schwit.example.web.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

/**
 *
 * @author scja0
 */
@Service
public class CardValidationImpl implements CardValidation{
	private BigInteger TEN = new BigInteger("10");

    @Override
    public boolean isValid(String cardNumber) {
    	System.out.println("The number is " + cardNumber);
        BigInteger number = new BigInteger(cardNumber);
        int digitSum = 0;
        int counter = 0;
        while (number.compareTo(BigInteger.ZERO) == 1)
        {
        	int digit = number.mod(TEN).intValue();
        	if (counter == 0)
        	{
            	digitSum = digitSum+doubleDigit(digit);
            	number = number.divide(TEN);
            	counter = 1;
            	System.out.println("Sum is: " + digitSum);
        	}
        	else if (counter == 1)
        	{
        		digitSum = digitSum+digit;
            	number = number.divide(TEN);
            	System.out.println("Sum is: " + digitSum);
            	counter = 0;
        	}

        }
        
        System.out.println("The digit sum is " + digitSum);
        return digitSum % 10 == 0;
    }
    
    private int doubleDigit(int digit)
    {
    	switch (digit) {
    	case 5: return 1;
    	case 6: return 3;
    	case 7: return 5;
    	case 8: return 7;
    	case 9: return 9;
    	default: return digit * 2;
    	}
    	
    }
    
    
}
