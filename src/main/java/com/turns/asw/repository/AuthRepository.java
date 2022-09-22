package com.turns.asw.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthRepository {
	
	@Query(value = "{call pk_turns.pr_create_turns(:userIn, :passIn) }", nativeQuery = true)
	public String auth(@Param("userIn") String user, 
   		  			   @Param("passIn") String password);
	
}
