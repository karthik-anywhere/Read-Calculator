package com.contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.store.Contact;
import com.store.ContactStore;
import com.store.Store;

@WebServlet("/contacts")
public class ContactManipulationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String reqId = request.getRequestURI().replace("/ContactForm/contacts/", "");
		Contact contactData = new Gson().fromJson(request.getReader(), Contact.class);
		String jsonData;
		ContactSearch contact = new ContactSearch();
		if (!reqId.equals("/ContactForm/contacts")) {
			jsonData = contact.getDataFromStoreById(reqId);
		} else {
			if (contactData != null) {
				jsonData = contact.getDataFromStore(contactData.getFirstName(), contactData.getLastName(),
						contactData.getEmail());
			} else {
				jsonData = contact.getContactsFromStore();
			}
		}
		out.println(jsonData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/add-contact");
		rd.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		JSONObject jsonData = new JSONObject();
		String key = request.getRequestURI().replace("/ContactForm/contacts/", "");
		Contact contactObj = new Gson().fromJson(request.getReader(), Contact.class);
		try {
			if (contactObj.getFirstName().length() > 1 && contactObj.getLastName().length() > 1
					&& !key.equals("/ContactForm/contacts")) {
				Store contact = new ContactStore();
				String resId = contact.updateContactInStore(key, contactObj);
				jsonData.put("id", resId);
			} else {
				response.setStatus(400);
				jsonData.put("error code", 400);
				jsonData.put("error message", "invalid firstname / lastname");
			}
		} catch (JSONException e) {
			RequestDispatcher rd = request.getRequestDispatcher("ErrorHandlerServlet");
			rd.forward(request, response);
		}
		out.println(jsonData);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String reqId = request.getRequestURI().replace("/ContactForm/contacts/", "");
		ContactStore contact = new ContactStore();
		try {
			out.println(contact.deleteContactById(reqId));
		} catch (JSONException e) {
			RequestDispatcher rd = request.getRequestDispatcher("ErrorHandlerServlet");
			rd.forward(request, response);
		}
	}

}
