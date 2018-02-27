package com.demo.graphql.repo;

import org.springframework.data.repository.CrudRepository;

import com.demo.graphql.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
