package com.demo.graphql.repo;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.demo.graphql.exception.BookNotFoundException;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.model.Personalinfo;
import com.demo.graphql.model.Usercompanies;
import com.demo.graphql.model.Userregistration;
import com.demo.graphql.model.Userrole;

public class Mutation implements GraphQLMutationResolver {

	private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepo userRepo;
	private PersonalInfoRepo personalInfoRepo;
	private UserCompaniesRepo userCompaniesRepo;
    
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, UserRepo userRepo, PersonalInfoRepo personalInfoRepo, UserCompaniesRepo userCompaniesRepo) {
		this.userRepo = userRepo;
		this.personalInfoRepo = personalInfoRepo;
		this.userCompaniesRepo = userCompaniesRepo;
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
    
    public boolean register(String username, Boolean userverified, String password, String firstname, String lastname, 
			String emailid, Boolean emailverified, String phonenumber, Boolean numberverified, String profileimage) {
		Userregistration user = userRepo.save(
				new Userregistration(
						username, 
						new Userrole(1), 
						userverified ? userverified : false, 
						password, 
						firstname == null ? "" : firstname, 
						lastname == null ? "" : lastname, 
						emailid, 
						emailverified ?  emailverified : false, 
						phonenumber, 
						numberverified ?  numberverified : false)
				);
		if(user != null)
			return true;
		return false;
	}
	
	public boolean addUpdatePersonalInfo(Personalinfo personalinfo) {
		return personalInfoRepo.save(personalinfo) != null ? true : false;
	}
	
	public boolean deletePersonalInfo(Integer infoid) {
		return personalInfoRepo.deleteInfo(infoid) > 0 ? true : false;
	}
	
	public boolean addUpdateCompanies(Usercompanies usercompanies) {
		return userCompaniesRepo.save(usercompanies) != null ? true : false;
	}
}
