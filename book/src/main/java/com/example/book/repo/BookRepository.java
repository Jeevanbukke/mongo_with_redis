package com.example.book.repo;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



import com.example.book.model.book;



public interface BookRepository extends MongoRepository<book, Integer>{

	
	List<book> findBycountry(String country);



}

