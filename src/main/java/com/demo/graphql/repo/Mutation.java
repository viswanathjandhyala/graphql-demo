package com.demo.graphql.repo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.demo.graphql.exception.BookNotFoundException;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;

public class Mutation implements GraphQLMutationResolver {

	private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
    		this.authorRepository = authorRepository; 
    		this.bookRepository = bookRepository;
    	}
    
    public Author newAuthor(String firstName, String lastName) { 
    		Author author = new Author(); 
    		author.setFirstName(firstName); 
    		author.setLastName(lastName); 
    		authorRepository.save(author); 
    		return author; 
    	} 
    
    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) { 
    		Book book = new Book(); 
    		book.setAuthor(new Author(authorId)); 
    		book.setTitle(title); 
    		book.setIsbn(isbn); 
    		book.setPageCount(pageCount != null ? pageCount : 0); 
    		bookRepository.save(book); 
    		return book; 
    	}
    
    public boolean deleteBook(Long id) { 
    		bookRepository.delete(id); 
    		return true; 
    	}
    
    public Book updateBookPageCount(Integer pageCount, Long id) { 
    		Book book = bookRepository.findOne(id); 
    		if(book == null) { 
    			throw new BookNotFoundException("The book to be updated was found", id); 
    		}
    		book.setPageCount(pageCount); 
    		bookRepository.save(book); 
    		return book; 
    	}
    
    public Book findBook(Long id) {
	    	Book book = bookRepository.findOne(id); 
	    	if(book == null) { 
	    		throw new BookNotFoundException("The requested object was not found", id); 
	    	}
	    	return book;
    }
}
