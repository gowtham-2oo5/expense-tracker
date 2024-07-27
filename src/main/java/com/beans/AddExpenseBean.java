package com.beans;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entities.Account;
import com.entities.Expense;
import com.services.AccountServices;
import com.services.ExpenseServices;

@ManagedBean(name = "expenseBean", eager = true)
public class AddExpenseBean {

	private Expense expense = new Expense();
	private Part file;
	private Account selectedAccount;
	private String accTitle;
	private List<String> accounts;
	private String dateString; // New property for date input as string

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@PostConstruct
	public void init() {
		System.out.println("Loading Data");
		loadData();
	}

	private void loadData() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session == null) {
			throw new IllegalStateException("No session found");
		}

		String username = (String) session.getAttribute("username");
		if (username == null) {
			throw new IllegalStateException("Username not found in session");
		}

		AccountServices accServices = new AccountServices();
		try {
			this.accounts = accServices.getAccountTitlesByUsername(username);
		} catch (NumberFormatException e) {
			System.err.println("Failed to parse username: " + username);
			e.printStackTrace();
		}
	}

	public String getAccTitle() {
		return accTitle;
	}

	public void setAccTitle(String accTitle) {
		this.accTitle = accTitle;
	}

	public List<String> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<String> accounts) {
		this.accounts = accounts;
	}

	public Account getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(Account selectedAccount) {
		AccountServices accServices = new AccountServices();
		this.selectedAccount = accServices.getAccountByTitle(accTitle);
	}

	public Expense getExpense() {
		return expense;
	}

	public void setExpense(Expense expense) {
		this.expense = expense;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public void addExpense() {
		try {
			if (file != null) {
				InputStream inputStream = file.getInputStream();
				byte[] fileData = new byte[inputStream.available()];
				inputStream.read(fileData);
				expense.setFileData(fileData);
			}

			AccountServices accS = new AccountServices();
			this.selectedAccount = accS.findAccountByTitle(accTitle);

			// Debug statement: Log selected account details
			System.out.println("Selected account: " + selectedAccount);

			expense.setAccount(selectedAccount);

			// Debug statement: Log before updating account balance
			System.out.println("UPDATING ACCOUNT BALANCE");

			accS.updateAccBalance(selectedAccount.getId(), this.expense.getAmount());

			// Debug statement: Print the date string before parsing
			System.out.println("Date string before parsing: '" + dateString + "'");

			// Trim the date string to remove any leading/trailing whitespace
			dateString = dateString.trim();

			// Convert dateString to LocalDate
			try {
				LocalDate date = LocalDate.parse(dateString, DATE_FORMATTER);
				expense.setDate(date);
			} catch (DateTimeParseException e) {
				e.printStackTrace();
				System.out.println("error"); // navigate to error page if date parsing fails
			}

			ExpenseServices es = new ExpenseServices();
			es.createExpense(expense);

			System.out.println("success"); // navigate to success page
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error"); // navigate to error page
		}
	}

}
