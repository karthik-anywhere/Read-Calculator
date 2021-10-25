package com.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

public class ContactStoreTest {

	Store contact = new ContactStore();
	Gson gson = new Gson();

	@Test
	public void testGetContactsFromStore() {
		contact.storeContactInStore("f2d3d2bd-9b1d-42b0-b624-1d62e130276b", "karthik", "kumar", "kk@gmail.com");
		assertEquals(
				"{\"f2d3d2bd-9b1d-42b0-b624-1d62e130276b\":{\"firstName\":\"karthik\","
						+ "\"lastName\":\"kumar\",\"email\":\"kk@gmail.com\"}}",
				gson.toJson(contact.getContactsFromStore()));
	}

	@Test
	public void testSearchByLastName() {
		contact.storeContactInStore("f2d3d2bd-9b1d-42b0-b624-1d62e130276b", "karthik", "kumar", "kk@gmail.com");
		assertEquals("{\"firstName\":\"karthik\"," + "\"lastName\":\"kumar\",\"email\":\"kk@gmail.com\"}",
				gson.toJson(contact.searchBylastName("kumar")));
	}

}
