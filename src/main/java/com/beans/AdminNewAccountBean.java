package com.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.entities.Account;
import com.services.AccountServices;
import com.services.UserServices;

@ManagedBean(name = "newAccount", eager = true)
public class AdminNewAccountBean {

	private String title;
	private Double totalIncome;
	
	// Injecting the service
	private AccountServices accServices = new AccountServices();
	private UserServices userService = new UserServices();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}

	// Submit method
	public void submit() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session == null) {
			throw new IllegalStateException("No session found");
		}

		String adminIdString = (String) session.getAttribute("adminId");
		String username = (String) session.getAttribute("username");
		if (adminIdString == null) {
			throw new IllegalStateException("Admin ID not found in session");
		}

		Account newAccount = new Account();
	
		newAccount.setUser(userService.getUserData(username)); // Set the adminID from session
		newAccount.setTitle(this.title);
		newAccount.setIncome(this.totalIncome);
		newAccount.setBalance(this.totalIncome); // Default balance to totalIncome
		newAccount.setTotalTransactions(0);

		accServices.createNewAccount(newAccount);
	
	}

}
