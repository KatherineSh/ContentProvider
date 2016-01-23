package com.kateryna.restservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.kateryna.restservice.model.Author;

@Repository("authorsRepository")
public class AuthorsRepositoryImpl implements AuthorsRepository {

	@PersistenceUnit(unitName="myEntityManagerFactory")
	private EntityManagerFactory emFactory;
	
/*	@PersistenceContext
	private EntityManager em;*/

	
	
	public List<Author> getAuthors() {
		EntityManager em = emFactory.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Author> authorsList = em.createQuery("SELECT e FROM Author e").getResultList();
		
		return authorsList;
	}
}
