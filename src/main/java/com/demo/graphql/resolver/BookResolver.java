package com.demo.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.repo.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book> {

	private AuthorRepository authorRepository;
	
	public BookResolver(AuthorRepository authorRepository) { 
		this.authorRepository = authorRepository; 
	}
	
	public Author getAuthor(Book book) { 
		return authorRepository.findOne(book.getAuthor().getId()); 
	}
	
}
