package com.projeto.api.controller;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.api.service.BookService;
import com.projeto.api.vo.Book;
import com.projeto.api.vo.GoogleBooksResponse;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

	@PostMapping("/book/save")
	@ResponseBody
	public Book saveBook(@RequestBody Book book){
		return bookService.saveBook(book);
	}

	@SuppressWarnings("null")
	@GetMapping("/books/{id}")
	@ResponseBody
	public ResponseEntity<Book> searchBook(@PathVariable("id") String id){
		Optional<Book> bookOptional = bookService.getBookById(id);
		
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			return ResponseEntity.ok(book);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/books/all")
	public @ResponseBody List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@SuppressWarnings("null")
	@GetMapping("/google/books/save/{theme}")
	@ResponseBody
	public List<Book> saveBooksFromGoogleApiToDB(@PathVariable("theme") String theme) throws Exception, Exception {
		try {
			ResponseEntity<GoogleBooksResponse> googleBooksResponse = bookService.buildRestToGoogleBookApi(theme);
			if (googleBooksResponse != null && googleBooksResponse.getBody().getItems() != null) {
				return bookService.saveBooksFromGoogleApi(googleBooksResponse.getBody());
            }
		}catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
	
}
