package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.User;
import com.services.AdminServices;


@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminServices adminServices;

	public AdminLoginServlet() {
		super();
		adminServices = new AdminServices();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");

			boolean authResult = adminServices.authenticateAdmin(uname, pass);
			System.out.println(uname + " " + pass);
			System.out.println(authResult);

			if (authResult) {
				// Authentication successful
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(5 * 60);
				// Get admin data
				User admin = adminServices.getAdminData(uname);

				if (admin != null) {
					// Set admin attributes in session
					session.setAttribute("adminName", admin.getName());
					session.setAttribute("username", admin.getUsername());
					session.setAttribute("adminId", Long.toString(admin.getId()));
					session.setAttribute("adminDp", admin.getBase64Image());

					//System.out.println("LOGGED IN");
					response.sendRedirect(request.getContextPath() + "/adminDashboard.jsf");
					response.getWriter().append("Logged in successfully");
				} else {
					// Admin data not found
					request.setAttribute("error", "Admin data not found");
					request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
				}
			} else {
				// Authentication failed
				request.setAttribute("error", "Invalid username or password");
				request.getRequestDispatcher("/adminLogin.jsp").forward(request, response);
			}

		} catch (Exception e) {
			response.getWriter().append("Error: " + e.getLocalizedMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
