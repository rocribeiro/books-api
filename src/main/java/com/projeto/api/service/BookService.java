package com.projeto.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projeto.api.controller.BookController;
import com.projeto.api.repository.BookRepository;
import com.projeto.api.vo.Book;
import com.projeto.api.vo.GoogleBooksResponse;
import com.projeto.api.vo.Items;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());
	
	@Value("${google.api.book.url}")
	String googleApiBookUrl;

	
	public void saveBook(Book book){
		bookRepository.save(book);
	}
	public Optional<Book> searchBookById(String id){
		return bookRepository.findById(id);
		
	}
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}

	public ResponseEntity<GoogleBooksResponse> buildRestToGoogleBookApi(String theme){        
			RestTemplate restTemplate = new RestTemplate();
			GoogleBooksResponse googleBooksResponse = restTemplate.getForObject(googleApiBookUrl.concat(theme), GoogleBooksResponse.class);
			return Optional.ofNullable(googleBooksResponse)
            .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	public List<Book> saveBooksFromGoogleApi( GoogleBooksResponse googleBooksResponse){

		List<Book> books = new ArrayList<>();
        for (Items googleBooksItems : googleBooksResponse.getItems()) {
			Book book = new Book();
        	book.setTitle(googleBooksItems.getVolumeInfo().getTitle());
         	book.setDescription(googleBooksItems.getVolumeInfo().getDescription());
            book.setLanguage(googleBooksItems.getVolumeInfo().getLanguage());

            saveBook(book);
			books.add(book);
        }
		return books;
	}
	
}
