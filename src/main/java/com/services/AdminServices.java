package com.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.entities.User;
import com.entities.UserType;

public class AdminServices {

	private EntityManagerFactory emf;

	public AdminServices() {
		emf = Persistence.createEntityManagerFactory("expense-tracker-v2");
	}

	public boolean authenticateAdmin(String username, String password) {
		EntityManager em = emf.createEntityManager();
		try {
			User admin = (User) em.createQuery(
					"SELECT a FROM User a WHERE a.username = :username AND a.password = :password AND a.userType = :type").setParameter("type", UserType.ADMIN)
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			return admin != null;
		} catch (NoResultException e) {
			return false;
		} finally {
			em.close();
		}
	}

	public User getAdminData(String username) {
		EntityManager em = emf.createEntityManager();
		try {
			return (User) em
					.createQuery("SELECT a FROM User a WHERE a.username = :username AND a.userType = 'Admin'")
					.setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
	
	public void addAdmin(User newAdmin) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newAdmin);
			em.getTransaction().commit();

		} catch (NoResultException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}
}