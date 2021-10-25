package com.store;

import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

public class ContactStore extends Store {

	@Override
	public String storeContactInStore(String firstName, String lastName, String email) {
		String id = generateID();
		contactMap.put(generateID(), new Contact(firstName, lastName, email));
		return id;
	}

	@Override
	public String storeContactInStore(String id, String firstName, String lastName, String email) {
		contactMap.put(id, new Contact(firstName, lastName, email));
		return id;
	}

	@Override
	public String updateContactInStore(String key, Contact contactObj) {
		contactMap.replace(key, contactObj);
		return key;
	}

	@Override
	public Contact searchByFirstName(String firstName) {
		for (Entry<String, Contact> i : contactMap.entrySet()) {
			if (i.getValue().getFirstName().equals(Contact.convertName(firstName))) {
				return contactMap.get(i.getKey());
			}
		}
		return null;
	}

	@Override
	public Contact searchBylastName(String lastName) {
		for (Entry<String, Contact> i : contactMap.entrySet()) {
			if (i.getValue().getLastName().equals(Contact.convertName(lastName))) {
				return contactMap.get(i.getKey());
			}
		}
		return null;
	}

	@Override
	public Contact searchByEmail(String email) {
		for (Entry<String, Contact> i : contactMap.entrySet()) {
			if (i.getValue().getEmail().equals(email)) {
				return contactMap.get(i.getKey());
			}
		}
		return null;
	}

	@Override
	public Contact searchByALL(String firstName, String lastName, String email) {
		for (Entry<String, Contact> i : contactMap.entrySet()) {
			if ((i.getValue().getFirstName().equals(Contact.convertName(firstName)))
					&& (i.getValue().getLastName().equals(Contact.convertName(lastName)))
					&& (i.getValue().getEmail().equals(email))) {
				return contactMap.get(i.getKey());
			}
		}
		return null;
	}

	@Override
	public JSONObject deleteContactById(String id) throws JSONException {
		JSONObject jsonData = new JSONObject();
		if (contactMap.remove(id) != null) {
			jsonData.put("id", id);
			return jsonData;
		} else {
			jsonData.put("error code", 404);
			jsonData.put("error message", "Resource not found for this ID");
			return jsonData;
		}
	}
}
