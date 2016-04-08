package com.kateryna.restservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kateryna.restservice.model.Author;
import com.kateryna.restservice.repository.AuthorsRepository;

@Service("authorsProvider")
public class AuthorsProviderImpl implements AuthorsProvider {
	
	@Autowired
	private AuthorsRepository authorsRepository;

	public List<Author> getAuthors() {
		return authorsRepository.get();
	}

	public boolean addAuthors(Author newAuthor) {
		return authorsRepository.add(newAuthor);
	}

/*	public boolean isExist(Author newAuthor) {
		
		return authorsRepository.isExist(newAuthor);
	}*/

}
