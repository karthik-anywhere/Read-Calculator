package com.contact.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

@WebFilter("/contacts/*")
public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession(false);

		if ((session != null) && (session.getAttribute("userName") != null)) {
			chain.doFilter(request, response);
		} else {
			JSONObject jsonData = new JSONObject();
			try {
				PrintWriter out = response.getWriter();
				httpServletResponse.setStatus(401);
				jsonData.put("error code", "401");
				jsonData.put("error message", "unauthorized request!");
				out.println(jsonData);
			} catch (JSONException e) {
				RequestDispatcher rd = request.getRequestDispatcher("ErrorHandlerServlet");
				rd.forward(request, response);
			}
		}
	}
}
