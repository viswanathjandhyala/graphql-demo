package com.demo.graphql.repo;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;

public class Query implements GraphQLQueryResolver {

	private BookRepository bookRepository;

	private AuthorRepository authorRepository;

	public Query(AuthorRepository authorRepository, BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public Iterable<Book> findAllBooks() { 
		return bookRepository.findAll(); 
	} 

	public Iterable<Author> findAllAuthors() { 
		return authorRepository.findAll(); 
	} 

	public long countBooks() { 
		return bookRepository.count(); 
	} 

	public long countAuthors() { 
		return authorRepository.count(); 
	}
	
}