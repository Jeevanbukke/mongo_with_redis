package com.example.book.model;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Books")

public class book implements Serializable {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private String id;
	private String name;
	private String city;
	private String country;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public book(String id, String name, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
	}

}
