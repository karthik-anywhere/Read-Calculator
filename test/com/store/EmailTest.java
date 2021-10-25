package com.store;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmailTest {
	EmailValidation email = new EmailValidation();

	@Test
	public void test() {
		assertTrue(email.validate("k@gmail.com"));
	}

	@Test
	public void test2() {
		assertFalse(email.validate("kA@gmail.com"));
	}

	@Test
	public void test3() {
		assertFalse(email.validate("kA@gmAil.COM"));
	}

}
