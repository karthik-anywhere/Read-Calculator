package com.store;

import java.util.HashMap;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import com.store.hashstorage.HashStorage;

public abstract class Store {

	HashStorage hs = HashStorage.getInstance();

	protected HashMap<String, Contact> contactMap = hs.getMap();

	public static String generateID() {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		return uuidAsString;
	}

	public HashMap<String, Contact> getContactsFromStore() {
		return contactMap;
	}

	// for test case , this method is overloaded by id
	public abstract String storeContactInStore(String id, String firstName, String lastName, String email);

	public abstract String storeContactInStore(String firstName, String lastName, String email);

	public abstract String updateContactInStore(String key, Contact contactobj);

	public abstract Contact searchByFirstName(String firstName);

	public abstract Contact searchBylastName(String lastName);

	public abstract Contact searchByEmail(String email);

	public abstract Contact searchByALL(String firstName, String lastName, String email);

	public abstract JSONObject deleteContactById(String id) throws JSONException;
}
