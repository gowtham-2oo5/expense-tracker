package com.beans;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.entities.Expense;
import com.services.ExpenseServices;

@ManagedBean(name = "expensesBean", eager = true)
@ViewScoped
public class GetExpensesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Expense> expenses;
	private ExpenseServices expenseServices = new ExpenseServices();

	public void init() {
		loadExpenses();
	}

	private void loadExpenses() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		if (session == null) {
			throw new IllegalStateException("No session found");
		}

		String userId = (String) session.getAttribute("adminId");
		if (userId == null) {
			throw new IllegalStateException("User ID not found in session");
		}

		try {
			this.expenses = expenseServices.getAllExpensesOfaUser(Long.parseLong(userId));
			logReceivedExpenses();
		} catch (Exception e) {
			// Log the error and handle it appropriately
			System.err.println("Failed to load expenses for user ID: " + userId);
			e.printStackTrace();
		}
	}

	private void logReceivedExpenses() {
		System.out.println("Received expenses: ");
		for (Expense expense : expenses) {
			System.out.println(expense.toString());
		}
	}

	// Getter method
	public List<Expense> getExpenses() {
		if (expenses == null) {
			loadExpenses();
		}
		return expenses;
	}

	public void downloadBill(Long expenseId) {
		Expense expense = expenseServices.findExpenseById(expenseId);
		if (expense != null && expense.getFileData() != null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			externalContext.responseReset();
			externalContext.setResponseContentType("application/pdf");
			externalContext.setResponseContentLength(expense.getFileData().length);
			externalContext.setResponseHeader("Content-Disposition",
					"attachment; filename=\"bill_" + expenseId + ".pdf\"");

			try (OutputStream output = externalContext.getResponseOutputStream()) {
				output.write(expense.getFileData());
				facesContext.responseComplete();
			} catch (IOException e) {
				e.printStackTrace(); // Or use a logger
			}
		}
	}
}
