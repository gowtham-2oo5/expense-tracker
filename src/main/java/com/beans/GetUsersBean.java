package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.entities.User;
import com.services.UserServices;

@ManagedBean(name = "usersBean", eager = true)
@ViewScoped
public class GetUsersBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> users;
	private UserServices userServices = new UserServices();

	@PostConstruct
	public void init() {
		loadUsers();
	}

	private void loadUsers() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session == null) {
			throw new IllegalStateException("No session found");
		}

		String adminId = (String) session.getAttribute("adminId");
		if (adminId == null) {
			throw new IllegalStateException("Admin ID not found in session");
		}

		try {
			this.users = userServices.getBasicUsers();
			logReceivedUsers();
		} catch (Exception e) {
			// Log the error and handle it appropriately
			System.err.println("Failed to load users for admin ID: " + adminId);
			e.printStackTrace();
		}
	}

	private void logReceivedUsers() {
		System.out.println("Received users: ");
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

	// Getter method
	public List<User> getUsers() {
		if (users == null) {
			loadUsers();
		}
		return users;
	}
}
