package com.apsposting.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.apsposting.exception.BookNotFoundException;
import com.apsposting.entity.Book;
import com.apsposting.repository.BookRepository;

public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book findById(Long id) {
		return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
	}
}
