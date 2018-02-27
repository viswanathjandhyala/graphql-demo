package com.demo.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.demo.graphql.exception.GraphQLErrorAdapter;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.repo.AuthorRepository;
import com.demo.graphql.repo.BookRepository;
import com.demo.graphql.repo.Mutation;
import com.demo.graphql.repo.Query;
import com.demo.graphql.resolver.BookResolver;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@SpringBootApplication
public class GraphqlDemoApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GraphqlDemoApplication.class);
    }
	
	@Bean 
	public BookResolver authorResolver(AuthorRepository authorRepository) { 
		return new BookResolver(authorRepository); 
	} 
	
	@Bean 
	public Query query(AuthorRepository authorRepository, BookRepository bookRepository) { 
		return new Query(authorRepository, bookRepository); 
	} 
	
	@Bean 
	public Mutation mutation(AuthorRepository authorRepository, BookRepository bookRepository) { 
		return new Mutation(authorRepository, bookRepository); 
	}

	public static void main(String[] args) {
		SpringApplication.run(GraphqlDemoApplication.class, args);
	}
	
	@Bean 
	public GraphQLErrorHandler errorHandler() { 
		return new GraphQLErrorHandler() { 
			@Override 
			public List<GraphQLError> processErrors(List<GraphQLError> errors) { 
				List<GraphQLError> clientErrors = 
						errors.stream() 
						.filter(this::isClientError) 
						.collect(Collectors.toList()); 
				List<GraphQLError> serverErrors = 
						errors.stream() 
						.filter(e -> !isClientError(e)) .map(GraphQLErrorAdapter::new) 
						.collect(Collectors.toList()); 
				List<GraphQLError> e = new ArrayList<>(); 
				e.addAll(clientErrors); e.addAll(serverErrors); 
				return e; 
			} 
			
			protected boolean isClientError(GraphQLError error) { 
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable); 
			} 
		}; 
	}
	
	@Bean 
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) { 
		return (args) -> { 
			Author author = new Author("Herbert", "Schildt"); 
			authorRepository.save(author); 
			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author)); 
		}; 
	}
}
