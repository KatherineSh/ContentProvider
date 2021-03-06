package com.kateryna.restservice.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="author")
public class Author {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="name",length=255, unique=true)
	private String name;

	public Author() {
	}
	
	public Author(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
