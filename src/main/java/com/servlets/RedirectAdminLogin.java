package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class RedirectAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RedirectAdminLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestDispatcher rd = request.getRequestDispatcher("/adminLogin.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			response.getWriter().append(e.getLocalizedMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
