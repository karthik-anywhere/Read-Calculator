package com.contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AddContactServletTest extends Mockito {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testContactData() throws IOException, ServletException {

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		ContactManipulationServlet contact = new ContactManipulationServlet();
		contact.doGet(request, response);

		assertEquals(result, new String("Full Name: Vinod Kashyap"));

	}

}
