package com.demo.graphql.repo;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.model.Personalinfo;
import com.demo.graphql.model.Usercompanies;
import com.demo.graphql.model.Userregistration;

public class Query implements GraphQLQueryResolver {

	private BookRepository bookRepository;

	private AuthorRepository authorRepository;

	private UserRepo userRepo;

	private PersonalInfoRepo personalInfoRepo;

	private UserCompaniesRepo userCompaniesRepo;

	public Query(AuthorRepository authorRepository, BookRepository bookRepository, UserRepo userRepo, PersonalInfoRepo personalInfoRepo, UserCompaniesRepo userCompaniesRepo) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.userRepo = userRepo;
		this.personalInfoRepo = personalInfoRepo;
		this.userCompaniesRepo = userCompaniesRepo;
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
	
	public Userregistration findDetails(String emailid, String username, String phonenumber) {
		return userRepo.findByEmailidOrUsernameOrPhonenumber(emailid, username, phonenumber);
	}
	
	public Userregistration getProfileDetails(String username) {
		return userRepo.findOne(username);
	}
	
	public Userregistration login(String username, String password) {
		return userRepo.findByUsernameAndPassword(username, password);
	}
	
	public Personalinfo getPersonalInfo(String username) {
		return personalInfoRepo.findByUserregistrationUsername(username);
	}
	
	public List<Usercompanies> getCompanies(String username) {
		return userCompaniesRepo.findByUserregistrationUsername(username);
	}
}