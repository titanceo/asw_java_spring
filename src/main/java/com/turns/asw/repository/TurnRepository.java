package com.turns.asw.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.turns.asw.model.Turn;

public interface TurnRepository extends JpaRepository<Turn, Long>{
	
	@Query(value = "{call pk_turns.pr_create_turns(:idIn, :dateStart, :dateEnd)}", nativeQuery = true)
	public List<Turn> createTurns(@Param("idIn") Long id, @Param("dateStart") Date dateStart,@Param("dateEnd") Date dateEnd);
}
