package com.turns.asw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turns.asw.model.Servicee;
import com.turns.asw.model.Turn;
import com.turns.asw.model.requestpersonalized.TurnCreate;
import com.turns.asw.service.TurnService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turns/")
public class TurnREST {
	
	@Autowired
	private TurnService turnService;
	
	@GetMapping 
	private ResponseEntity<List<Turn>> getAllProducts(){
		return ResponseEntity.ok(turnService.findAll());
	}
	
	
	@PostMapping(value="createTurns")
	private ResponseEntity<Turn> createTurns(@RequestBody TurnCreate turnCreate){
		try {
			turnService.createTurns(turnCreate.getId(), turnCreate.getDate_start(), turnCreate.getDate_end());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@DeleteMapping(value="delete/{id}")
	private ResponseEntity<Turn> deleteProduct(@PathVariable ("id") Long idTurn){
		
		Optional<Turn> turn = turnService.findById(idTurn);
		if(!turn.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		turnService.deleteById(idTurn);
		return ResponseEntity.ok(new Turn());
		//return  ResponseEntity.ok(!(turnService.findById(idProduct)!=null));

	}
	
	@GetMapping(value="recover/{id}")
	private Optional<Turn> getProductId(@PathVariable ("id") Long idProduct){
		return turnService.findById(idProduct);
	}
	
}
