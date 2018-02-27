package com.demo.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.graphql.model.Userregistration;

public interface UserRepo extends JpaRepository<Userregistration, String> {

	Userregistration findByEmailidOrUsernameOrPhonenumber(String emailid, String username, String phonenumber);
	
	Userregistration findByUsernameAndPassword(String username, String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE Userregistration u SET u.profileimage = :profileimage WHERE u.username = :username")
	int updateProfileImage(@Param("profileimage") String profileimage, @Param("username") String username);
}
