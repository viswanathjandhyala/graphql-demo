package com.demo.graphql.repo;

import org.springframework.data.repository.CrudRepository;

import com.demo.graphql.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
