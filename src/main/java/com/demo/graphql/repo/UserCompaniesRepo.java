package com.demo.graphql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.graphql.model.Usercompanies;

public interface UserCompaniesRepo extends JpaRepository<Usercompanies, Integer> {

	List<Usercompanies> findByUserregistrationUsername(String username);
}
