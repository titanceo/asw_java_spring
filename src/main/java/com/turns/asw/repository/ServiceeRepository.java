package com.turns.asw.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turns.asw.model.Servicee;

public interface ServiceeRepository extends JpaRepository<Servicee, Long>{
	
	@Query(value = "SELECT * FROM asw_services s WHERE s.id_commerce = :id_commerce", nativeQuery = true)
	public List<Servicee> findByCommerce(@Param("id_commerce") Long id_commerce);
	
}
