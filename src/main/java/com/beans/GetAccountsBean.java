package com.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.entities.Account;
import com.services.AccountServices;

@ManagedBean(name = "accs", eager = true)
@ViewScoped
public class GetAccountsBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Account> data;

//	private RemoteAdminAccount racc = new AdminAccountServices();
	private AccountServices accServices = new AccountServices();

	public void init() {
		loadData();
	}

	private void loadData() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session == null) {
			throw new IllegalStateException("No session found");
		}

		String username = (String) session.getAttribute("username");
		if (username == null) {
			throw new IllegalStateException("Admin ID not found in session");
		}

		try {
			// Integer adminId = Integer.parseInt(adminIdString);
			// this.data = racc.getAdminAccsById(adminId);
			this.data = accServices.getAccountsByUsername(username);
			logReceivedData();
		} catch (NumberFormatException e) {
			// Log the error and handle it appropriately
			System.err.println("Failed to parse admin username: " + username);
			e.printStackTrace();
		}
	}

	private void logReceivedData() {
		System.out.println("Received data: ");
		for (Account ac : data) {
			System.out.println(ac.toString());
		}
	}

	// Getter method
	public List<Account> getData() {
		if (data == null) {
			loadData();
		}
		return data;
	}

}
