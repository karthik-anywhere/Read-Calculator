package com.auth;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoginTest {

	Login l = new Login("karthik", "password123");

	@Test
	public void testGetName() {
		assertEquals("karthik", l.getUserName());
	}

	@Test
	public void testPassword() {
		assertEquals("password123", l.getPassWord());
	}
}
