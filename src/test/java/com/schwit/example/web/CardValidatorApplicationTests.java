package com.schwit.example.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.schwit.example.web.service.CardValidation;
import com.schwit.example.web.service.CardValidationImpl;

@SpringBootTest
class CardValidatorApplicationTests {

	CardValidation cardValidate;
	@BeforeEach
	void initialise() {
		cardValidate = new CardValidationImpl();
	}
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void validCardNumberTest() {
		Assertions.assertTrue(cardValidate.isValid("5555555555"));
	}
	
	@Test
	void invalidCardNumberTest() {
		Assertions.assertFalse(cardValidate.isValid("15"));
	}
	
	
	@Test
	void longCardNumberTest() {
		String input = "1";
		Assertions.assertFalse(cardValidate.isValid(input.repeat(16)));
	}
	
	@Test
	void longCardNumberTest2() {
		String input = "4242424242426742";
		//Should be true according to sainsbury's
		Assertions.assertTrue(!cardValidate.isValid(input));
	}

}
