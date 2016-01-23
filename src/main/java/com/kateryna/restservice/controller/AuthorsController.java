package com.kateryna.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kateryna.restservice.model.Author;
import com.kateryna.restservice.service.AuthorsProvider;

@RestController
public class AuthorsController {

	@Autowired
	private AuthorsProvider authorsProvider;
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
    public @ResponseBody List<Author> mainPage() {
		
		
		/*List<Author> authors = new ArrayList<Author>();
		
		authors.add(new Author("Carrie Blum"));
		authors.add(new Author("Kri Forest"));
		authors.add(new Author("Donald Trump"));*/
		
		List<Author> authors = authorsProvider.getAuthors();
		return authors;
	}
}
