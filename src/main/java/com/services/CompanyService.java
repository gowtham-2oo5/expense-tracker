package com.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entities.Company;

public class CompanyService {

	private EntityManagerFactory emf;

	public CompanyService() {
		emf = Persistence.createEntityManagerFactory("expense-tracker-v2");
	}

	public void saveCompany(Company company) {
		EntityManager em = null;
		EntityTransaction transaction = null;
		try {
			em = emf.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(company);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			// Optionally, you can throw a custom exception or handle it differently
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}
}
