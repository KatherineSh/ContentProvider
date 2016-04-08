package com.kateryna.restservice.repository;

import java.util.List;

import com.kateryna.restservice.model.Author;

public interface AuthorsRepository {

	public List<Author> get();
	
	public boolean add(Author newAuthor);

	//public boolean isExist(Author newAuthor);
}
