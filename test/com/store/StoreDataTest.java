package com.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StoreDataTest {

	Store c = new ContactStore();

	@Test
	public void test() {
		assertEquals("5be6a027-a3c7-4756-aa9c-3aec8fb59e83",
				c.storeContactInStore("5be6a027-a3c7-4756-aa9c-3aec8fb59e83", "karthik", "kumar", "karthik@gmail.com"));
	}
}
