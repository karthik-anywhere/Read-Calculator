package com.store;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

public class SearchByEmailTest {

	Store contact = new ContactStore();
	Gson gson = new Gson();

	@Test
	public void testSearchByEmail_If_Available() {
		contact.storeContactInStore("f2d3d2bd-9b1d-42b0-b624-1d62e130276b", "karthik", "kumar", "kk@gmail.com");
		assertEquals("{\"firstName\":\"karthik\"," + "\"lastName\":\"kumar\",\"email\":\"kk@gmail.com\"}",
				gson.toJson(contact.searchByEmail("kk@gmail.com")));
	}

	@Test
	public void testSearchByEmail_If_Not_Available() {
		contact.storeContactInStore("f2d3d2bd-9b1d-42b0-b624-1d62e130276b", "karthik", "kumar", "kk@gmail.com");
		assertEquals("null", gson.toJson(contact.searchByEmail("karthi@gmail.com")));
	}

}
