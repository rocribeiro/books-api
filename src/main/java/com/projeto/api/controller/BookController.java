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

	@PostMapping("/book")
	public @ResponseBody String saveBook(@RequestBody Book book){
		bookService.saveBook(book);
		return "OK";
	}
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> searchBook(@PathVariable("id") String id){
		return bookService.searchBookById(id);
	
	}

	@GetMapping("/all/books")
	public @ResponseBody List<Book> getAllBooks(){
		return bookService.getAllBooks();
	
	}
	
	@GetMapping("/books/save/{theme}")
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
