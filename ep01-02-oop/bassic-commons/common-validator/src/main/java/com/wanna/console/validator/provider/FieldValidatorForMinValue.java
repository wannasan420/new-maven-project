package com.wanna.console.validator.provider;

import java.lang.reflect.Field;

import com.wanna.console.validator.FieldError;
import com.wanna.console.validator.annotation.MinValue;

public class FieldValidatorForMinValue extends AbstractFieldValidator {

	@Override
	public FieldError validate(Field field, Object object) {
		
		try {
			var annotation = field.getDeclaredAnnotation(MinValue.class);
			
			if(null != annotation && isNumberType(field)) {
				
				field.setAccessible(true);
				var value = field.get(object);
				
				if(null != value && isViolate(value, annotation)) {
					return new FieldError(field.getName(), annotation.message());
				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	private boolean isViolate(Object data, MinValue annotation) {
		
		if(data instanceof Byte value) {
			return value < annotation.value();
		}

		if(data instanceof Short value) {
			return value < annotation.value();
		}

		if(data instanceof Integer value) {
			return value < annotation.value();
		}

		return (Long)data < annotation.value();
	}

}