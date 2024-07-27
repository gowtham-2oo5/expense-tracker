package com.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="redirectAdmin", eager = true)
@RequestScoped
public class RedirectAdminBean {

	public String backHome() {
		return "adminDashboard?faces-redirect=true";
	}

	public String addUsers() {
		return "admin-AddUser?faces-redirect=true";
	}
	public String createCorpUser() {
		return "admin-createCorporateUser?faces-redirect=true";
	}
	public String manageUsers() {
		return "admin-ManageUsers?faces-redirect=true";
	}
	
	public String createCompany() {
		return "admin-createCompany?faces-redirect=true";
	}
	
	public String manageCorpUsers() {
		return "admin-ManageCorpUsers?faces-redirect=true";
	}
	
	public String manageCompanies() {
		return "admin-ManageCompanies??faces-redirect=true";
	}
	
	public String addExpense() {
		return "admin-addExpense?faces-redirect=true";
	}
	
	public String manageExpenses() {
		return "admin-ManageExpense?faces-redirect=true";
	}
	
	public String createNewAdmin() {
		return "admin-newAdmin?faces-redirect=true";
	}
	
	public String createAccount() {
		return "admin-createAccount?faces-redirect=true";
	}
	
	public String manageAccounts() {
		return "admin-ManageAccounts?faces-redirect=true";
	}
	
	public String accountSettings() {
		return "admin-Settings?faces-redirect=true";
	}	
	
	public void adminLogout() {
	    System.out.println("Entered admin logout");
	    try {
	        FacesContext.getCurrentInstance().getExternalContext().redirect("adminLogout");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
