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

import com.turns.asw.model.Service;
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
	
	@PostMapping
	private ResponseEntity<Turn> saveProdut(@RequestBody Turn turn){
		
		try {
			Turn productSave = turnService.save(turn);			
			return ResponseEntity.created(new URI("/products/"+productSave.getId())).body(productSave);			
		} catch (Exception e) {
			return ResponseEntity.ok(turnService.getById(Long.valueOf(turn.getId())));
		}		
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
	private ResponseEntity<Boolean> deleteProduct(@PathVariable ("id") Long idProduct){
		
		turnService.deleteById(idProduct);
		return  ResponseEntity.ok(!(turnService.findById(idProduct)!=null));
	}
	
	@GetMapping(value="recover/{id}")
	private Optional<Turn> getProductId(@PathVariable ("id") Long idProduct){
		return turnService.findById(idProduct);
	}
	
	@PostMapping(value="savegroup")
	private boolean saveProdutGroup(@RequestBody List<Turn> product){
		
		
		try {
			for (Turn p : product) {
				Turn productSave = turnService.save(p);	
	        }
			return true;
			//return ResponseEntity.created(new URI("/products/"+productSave.getId())).body(productSave);			
		} catch (Exception e) {
			return false;
			//return ResponseEntity.ok(productService.getById(Long.valueOf(product.getId())));
		}		

	}
}
