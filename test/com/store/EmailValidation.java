package com.store;

public class EmailValidation {

	public Boolean validate(String email) {
		for (int i = 0; i < email.length(); i++) {
			if (Character.isUpperCase(email.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
