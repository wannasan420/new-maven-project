package com.wanna.exceptions.demo;

public class Class2 {

	private Class3 instance;

	public Class2() {
		instance = new Class3();
	}
	
	public int divide(int a, int b) {
		
		System.out.println("Class 2 Work");
		
		try {
			
			var value = instance.divide(a, b);
			return value;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Class 2 Work End");
		
		return 0;
	}
	
}
