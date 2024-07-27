package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Account;
import com.entities.Expense;

public class ExpenseServices {

	EntityManagerFactory emf;

	public ExpenseServices() {
		emf = Persistence.createEntityManagerFactory("expense-tracker-v2");
	}

	public void createExpense(Expense e) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			System.out.println("Created Expense");
			System.out.println(e.toString());
		} catch (NoResultException e1) {
			e1.printStackTrace();
		} finally {
			em.close();
		}
	}

	public List<Expense> getAllExpensesOfaUser(Long userId) {
		EntityManager em = emf.createEntityManager();
		List<Expense> expenses = null;
		try {
			// Retrieve accounts by user ID
			AccountServices accountServices = new AccountServices();
			List<Account> accounts = accountServices.getAccountsByUserId(userId);
			if (accounts != null && !accounts.isEmpty()) {
				// Retrieve expenses associated with the accounts
				TypedQuery<Expense> query = em.createQuery("SELECT e FROM Expense e WHERE e.account IN :accounts",
						Expense.class);
				query.setParameter("accounts", accounts);
				expenses = query.getResultList();
			}
		} catch (PersistenceException e) {
			handleException(em, e);
		} finally {
			em.close();
		}
		return expenses;
	}

	private void handleException(EntityManager em, PersistenceException e) {
		if (em != null && em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
		e.printStackTrace();
	}

	public Expense findExpenseById(Long expenseId) {
		EntityManager em = emf.createEntityManager();
		Expense expense = null;
		try {
			expense = em.find(Expense.class, expenseId);
		} finally {
			em.close();
		}
		return expense;
	}

}
