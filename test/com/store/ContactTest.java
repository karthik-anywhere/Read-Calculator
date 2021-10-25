package com.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContactTest {

	@Test
	void test() {
		Contact c = new Contact("karthik", "kumar", "karthik@gmail.com");
		assertEquals("Karthik", c.getFirstName());
	}

	@Test
	void test2() {
		Contact c = new Contact("james", "kumar", "karthik@gmail.com");
		assertEquals("James", c.getFirstName());
	}

	@Test
	void test3() {
		Contact c = new Contact("jaMes", "kumar", "karthik@gmail.com");
		assertEquals("James", c.getFirstName());
	}

	@Test
	void test4() {
		Contact c = new Contact("JaMeS", "kumar", "karthik@gmail.com");
		assertEquals("James", c.getFirstName());
	}

	@Test
	void test5() {
		Contact c = new Contact("jAMes", "kumar", "karthik@gmail.com");
		assertEquals("James", c.getFirstName());
	}

	@Test(expected = IllegalArgumentException.class)
	void test6() {
		Contact c = new Contact("", "kumar", "karthik@gmail.com");
		assertEquals("James", c.getFirstName());
	}
}
