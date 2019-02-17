package com.projeto.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.api.repository.BookRepository;
import com.projeto.api.vo.Book;
@Service
public class BookService {
	@Autowired
	BookRepository br;
	
	public void saveBook(Book book){
		br.save(book);
	}
	public Optional<Book> searchBookById(Long id){
		return br.findById(id);
		
	}
	
}
