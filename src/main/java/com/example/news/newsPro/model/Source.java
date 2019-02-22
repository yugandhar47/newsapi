package com.example.news.newsPro.model;

import javax.persistence.*;

@Entity
public class Source {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
