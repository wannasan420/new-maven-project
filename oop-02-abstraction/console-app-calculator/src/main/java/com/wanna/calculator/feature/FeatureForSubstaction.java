package com.wanna.calculator.feature;

import com.wanna.console.app.AbstractFeature;
import com.wanna.console.app.UserInputs;
    
public class FeatureForSubstaction extends AbstractFeature{

	public FeatureForSubstaction(int id) {
		super(id,"Substract Calculation");
		
	}

	@Override
	public void doBusiness() {
		
		int first = getFirstNumber();
		
		int second = getSecondNumber();
		
		doSubstractionAndShowResult(first,second);
	}

	private void doSubstractionAndShowResult(int first, int second) {
		
		System.out.printf("%d - %d = %d %n",first,second,first-second);
		
	}

	private int getSecondNumber() {
		
		int first = UserInputs.readInt("First Digit : ");
		return first;
	}

	private int getFirstNumber() {
		int second = UserInputs.readInt("Second Digit : ");
		return second;
	}

}
