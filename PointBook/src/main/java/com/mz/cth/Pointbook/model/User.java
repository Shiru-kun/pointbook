package com.mz.cth.Pointbook.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name; 

	@OneToMany
	private List<PointBook> pointBook;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PointBook> getPointBook() {
		return pointBook;
	}

	public void setPointBook(List<PointBook> pointBook) {
		this.pointBook = pointBook;
	}

	public User( String name) {
		
		this.name = name;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	

}
