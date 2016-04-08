package com.kateryna.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.kateryna.restservice.model.Author;
import com.kateryna.restservice.service.AuthorsProvider;

@RestController
public class AuthorsController {

	@Autowired
	private AuthorsProvider authorsProvider;
	
	@RequestMapping(value = "/authors", method = RequestMethod.GET)
    public @ResponseBody List<Author> getAllAuthors() {
				
		List<Author> authors = authorsProvider.getAuthors();
		return authors;
	}
	

	@RequestMapping(value = "/authors", method = RequestMethod.POST)
    public ResponseEntity<Void> addAuthor(@RequestBody String authorName, UriComponentsBuilder ucBuilder) {
		
		Author author = new Author(authorName);
		
		/*if (authorsProvider.isExist(newAuthor)) {
            System.out.println("REST: Author with name " + newAuthor.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
		
		boolean isAdded = authorsProvider.addAuthors(author);
		if(isAdded == false) {
			System.out.println("-------------------------REST: Author with name " + author.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		//HttpHeaders headers = new HttpHeaders();
        //headers.setLocation(ucBuilder.path("/authors/{name}").buildAndExpand(newAuthor.getName()).toUri());
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
}
