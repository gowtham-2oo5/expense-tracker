package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import com.entities.User;
import com.entities.UserType;

public class UserServices {

	private EntityManagerFactory emf;

	public UserServices() {
		emf = Persistence.createEntityManagerFactory("expense-tracker-v2");
	}

	public List<User> getBasicUsers() {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT u FROM User u WHERE u.userType = :userType", User.class)
					.setParameter("userType", UserType.BASIC).getResultList();
		} finally {
			em.close();
		}
	}

	public User getUserData(String username) {
		EntityManager em = emf.createEntityManager();
		try {
			return (User) em.createQuery("SELECT a FROM User a WHERE a.username = :username")
					.setParameter("username", username).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}

	public void addUser(User newUser) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(newUser);
			em.getTransaction().commit();
			System.out.println("Created user");
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
