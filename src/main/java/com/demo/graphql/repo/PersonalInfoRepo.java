package com.demo.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.graphql.model.Personalinfo;

public interface PersonalInfoRepo extends JpaRepository<Personalinfo, Integer>, JpaSpecificationExecutor<Personalinfo> {

	Personalinfo findByUserregistrationUsername(String username);
	
	@Transactional
	@Modifying
	@Query("UPDATE Personalinfo p SET p.documents = :documents where p.personalinfoid = :personalinfoid")
	int updateDocuments(@Param("documents") String documents, @Param("personalinfoid") Integer personalinfoid);
	
	@Transactional
	@Modifying
	@Query("delete from Personalinfo where personalinfoid = :personalinfoid")
	int deleteInfo(@Param("personalinfoid") Integer personalinfoid);
}
