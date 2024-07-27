package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.entities.Account;
import com.entities.User;

public class AccountServices {

	private EntityManagerFactory emf;

	public AccountServices() {
		emf = Persistence.createEntityManagerFactory("expense-tracker-v2");
	}

	public void createNewAccount(Account newAccount) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(newAccount);
			em.getTransaction().commit();
			System.out.println("Created account");
			System.out.println(newAccount.toString());
		} catch (NoResultException e) {

		} finally {
			em.close();
		}
	}

	public List<Account> getAccountsByUsername(String username) {
		EntityManager em = null;
		List<Account> accounts = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			// Fetch the User entity by username
			User user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
					.setParameter("username", username).getSingleResult();
			// Fetch the accounts associated with the user
			accounts = em.createQuery("SELECT a FROM Account a WHERE a.user = :user", Account.class)
					.setParameter("user", user).getResultList();
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			handleException(em, e);
		} finally {
			closeEntityManager(em);
		}
		return accounts;
	}

	public List<Account> getAccountsByUserId(Long userId) {
		EntityManager em = null;
		List<Account> accounts = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			// Fetch the User entity by user ID
			User user = em.createQuery("SELECT u FROM User u WHERE u.id = :userId", User.class)
					.setParameter("userId", userId).getSingleResult();
			// Fetch the accounts associated with the user
			accounts = em.createQuery("SELECT a FROM Account a WHERE a.user = :user", Account.class)
					.setParameter("user", user).getResultList();
			em.getTransaction().commit();
		} catch (PersistenceException e) {
			handleException(em, e);
		} finally {
			closeEntityManager(em);
		}
		return accounts;
	}

	private void handleException(EntityManager em, PersistenceException e) {
		if (em != null && em.getTransaction().isActive()) {
			em.getTransaction().rollback();
		}
		e.printStackTrace();
	}

	private void closeEntityManager(EntityManager em) {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}

	public Account findAccountById(Long id) {
		EntityManager em = null;
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Fetch the Account entity by ID
			account = em.createQuery("SELECT a FROM Account a WHERE a.id = :id", Account.class).setParameter("id", id)
					.getSingleResult();

			em.getTransaction().commit();
		} catch (NoResultException e) {
			// Handle the case where no result is found (e.g., log the exception)
			System.err.println("Account not found for ID: " + id);
		} catch (PersistenceException e) {
			// Handle other persistence exceptions
			if (em != null) {
				em.getTransaction().rollback();
			}
			handleException(em, e);
		} finally {
			if (em != null) {
				closeEntityManager(em);
			}
		}
		return account;
	}

	public Account findAccountByTitle(String accTitle) {
		EntityManager em = null;
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Fetch the Account entity by ID
			account = em.createQuery("SELECT a FROM Account a WHERE a.title = :title", Account.class)
					.setParameter("title", accTitle).getSingleResult();

			em.getTransaction().commit();
		} catch (NoResultException e) {
			// Handle the case where no result is found (e.g., log the exception)
			System.err.println("Account not found for ID: " + accTitle);
		} catch (PersistenceException e) {
			// Handle other persistence exceptions
			if (em != null) {
				em.getTransaction().rollback();
			}
			handleException(em, e);
		} finally {
			if (em != null) {
				closeEntityManager(em);
			}
		}
		return account;
	}

	public List<String> getAccountTitlesByUsername(String username) {
		EntityManager em = null;
		List<String> accounts = new ArrayList<>();
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Fetch the User entity by username
			User user = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class)
					.setParameter("username", username).getSingleResult();

			// Fetch the account titles associated with the user
			accounts = em.createQuery("SELECT a.title FROM Account a WHERE a.user = :user", String.class)
					.setParameter("user", user).getResultList();

			em.getTransaction().commit();
		} catch (PersistenceException e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace(); // Handle the exception as needed
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return accounts;
	}

	public Account getAccountByTitle(String accTitle) {
		EntityManager em = null;
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Fetch the Account entity by ID
			account = em.createQuery("SELECT a FROM Account a WHERE a.title = :title", Account.class)
					.setParameter("id", accTitle).getSingleResult();

			em.getTransaction().commit();
		} catch (NoResultException e) {
			// Handle the case where no result is found (e.g., log the exception)
			System.err.println("Account not found for ID: " + accTitle);
		} catch (PersistenceException e) {
			// Handle other persistence exceptions
			if (em != null) {
				em.getTransaction().rollback();
			}
			handleException(em, e);
		} finally {
			if (em != null) {
				closeEntityManager(em);
			}
		}
		return account;
	}

	public void updateAccBalance(Long accountId, Double amount) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();

			// Debug statement: Log the account ID
			System.out.println("Fetching account with ID: " + accountId);

			// Find the account by ID
			Account account = em.find(Account.class, accountId);

			if (account != null) {
				// Debug statement: Log the account details before updating
				System.out.println("Account found: " + account);

				// Update the balance
				account.setBalance(account.getBalance() - amount);

				// Debug statement: Log the account details after updating
				System.out.println("Account balance before merge: " + account.getBalance());

				em.merge(account);

				// Debug statement: Log success message
				System.out.println("Account balance updated successfully");
			} else {
				System.err.println("Account not found with ID: " + accountId);
			}

			em.getTransaction().commit();
		} catch (Exception e) {
			if (em != null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

}
