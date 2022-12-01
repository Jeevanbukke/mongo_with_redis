package com.example.book.controller;

	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.model.book;
import com.example.book.repo.BookRepository;
import com.example.book.service.BookService;




	@RestController
	@RequestMapping("/book")
	public class Controller  {
	    @Autowired
	    private BookRepository bookRepository;
	    @PostMapping("/")
	    public ResponseEntity<?> addbook(@RequestBody book book1 )
	    {
	    book1.setId("BOOK_"+ BookService.generateSequence(book.SEQUENCE_NAME));
	        book save = this.bookRepository.save(book1);
	        return ResponseEntity.ok(save);
	    }
	    
	    @GetMapping("/")
	 
	    public ResponseEntity<?> getStudents()
	    {
	        
	        return ResponseEntity.ok(this.bookRepository.findAll());
	    }
	    @GetMapping("/{country}")
	    @Cacheable(value="book", key="#country")
        public List<book> getbookBycountry(@PathVariable String country){
        	return bookRepository.findBycountry(country);
        }
	}

