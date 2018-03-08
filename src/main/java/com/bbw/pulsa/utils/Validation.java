package com.bbw.pulsa.utils;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
