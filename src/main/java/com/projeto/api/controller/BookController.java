package com.projeto.api.controller;


import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.projeto.api.service.BookService;
import com.projeto.api.vo.Book;

@Controller
public class BookController {
	@Autowired
	BookService bs;

	@PostMapping("/book")
	public @ResponseBody String saveBook(@RequestBody Book book){
		bs.saveBook(book);
		return "OK";
	}
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> searchBook(@PathVariable("id") Long id){
		return bs.searchBookById(id);
	
	}
	
	@GetMapping("/books")
	public void searchBooks() throws Exception, Exception {
			Document doc = Jsoup.connect("https://kotlinlang.org/docs/books.html").get();
			Elements titles = doc.select("h2");
			Elements descriptions = doc.select("p");
			Elements languages = doc.select("div [class=\"book-lang\"]");
			
			for (int i=0;i<titles.size();i++) {
				Book book = new Book();
				book.setTitle(titles.get(i).text());
				book.setLanguage(languages.get(i).text());
				book.setDescription(descriptions.get(i).text());
				saveBook(book);
			}

	}
	
}
