package com.wanna.exceptions.demo;

public class Application {

	public static void main(String[] args) {
		
		var instance = new Class1();
		
		System.out.println("Main Work");
		
		var value = instance.divide(10, 5); 
		
		System.out.printf("Value is %d%n",value);
		
		System.out.println("Main Work End");
		
		
	}

}
