package com.kateryna.restservice.service;

import java.util.List;

import com.kateryna.restservice.model.Author;


public interface AuthorsProvider {
	
	public List<Author> getAuthors();

	public boolean addAuthors(Author newAuthor);

	//public boolean isExist(Author newAuthor);
}
