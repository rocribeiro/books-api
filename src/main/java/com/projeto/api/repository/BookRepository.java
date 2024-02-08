package com.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.api.vo.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
	
}
