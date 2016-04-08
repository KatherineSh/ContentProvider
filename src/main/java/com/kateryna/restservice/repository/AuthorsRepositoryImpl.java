package com.kateryna.restservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.kateryna.restservice.model.Author;

@Repository("authorsRepository")
public class AuthorsRepositoryImpl implements AuthorsRepository {

	@PersistenceUnit(unitName="myEntityManagerFactory")
	private EntityManagerFactory emFactory;
	
	//@PersistenceContext(type=PersistenceContextType.EXTENDED)
	//private EntityManager em;
	
	public List<Author> get() {
		EntityManager em = emFactory.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Author> authorsList = em.createQuery("SELECT e FROM Author e").getResultList();
		
		return authorsList;
	}
/*	@Transactional
	public boolean isExist(Author newAuthor) {
		
		EntityManager em = emFactory.createEntityManager();
		//CriteriaQuery<Author> criteria = em.getCriteriaBuilder().createQuery(Author.class);
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		
		Root<Author> author = query.from(Author.class);
		query.select(builder.count(author));
		query.where(builder.equal(author.get("name"), newAuthor.getName()));
		
		Long existedCount = em.createQuery(query).getSingleResult();
		
		
		//Author result = em.createQuery( criteria ).
		return (existedCount > 0) ? true : false;
	}*/

	//@Transactional(propagation=Propagation.REQUIRED)
	public boolean add(Author newAuthor) {
		
		boolean isAdded = false;
		EntityManager em = emFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Long> query = builder.createQuery(Long.class);
		
		Root<Author> author = query.from(Author.class);
		query.select(builder.count(author));
		query.where(builder.equal(author.get("name"), newAuthor.getName()));
		
		Long existedCount = em.createQuery(query).getSingleResult();
		if(existedCount == 0) {
			em.persist(newAuthor);
			em.flush();
			isAdded = true;
		}
		tr.commit();
		System.out.println("------------REST: persist");
		return isAdded;
	}
}
