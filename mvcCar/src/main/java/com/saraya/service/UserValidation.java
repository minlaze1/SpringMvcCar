package com.saraya.service;

public class UserValidation {
  
    
	public boolean isValid(String username,String password) {
		return username.equalsIgnoreCase("lamine")&&password.equals("mypass");
	}
}
