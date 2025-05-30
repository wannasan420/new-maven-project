package com.wanna.online.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.wanna.console.validator.Validator;
import com.wanna.online.validator.domain.Student;

public class StringValidatorTest {

	private Validator validator = Validator.getInstance();
	
	@ParameterizedTest
	@CsvSource({
		"Aung Aung,111111,2004-07-11",
		"Aung Aung,111111111111,2004-07-11"
	
	})
	public void test_success(String name, String phone, String dob) throws ParseException {
		
		var df = new SimpleDateFormat("yyyy-MM-dd");
		var input = new Student(name,phone,df.parse(dob));
		
		var result = validator.validate(input);
		assertFalse(result.hasErrors());
		
	}
	   
	@ParameterizedTest
	@CsvSource({
		" , 11111",
		" , 1111111111111"
	})
	public void test_failure(String name, String phone) {
		
		var input = new Student(name,phone,null);
		var result = validator.validate(input);
		
		assertTrue(result.hasErrors());
		assertEquals(3, result.getErrors().length);
		
	}
	
}
