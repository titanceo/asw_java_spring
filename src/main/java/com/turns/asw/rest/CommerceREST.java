package com.turns.asw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turns.asw.model.Commerce;
import com.turns.asw.model.Turn;
import com.turns.asw.service.CommerceService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commerces/")
public class CommerceREST {
	
	@Autowired
	private CommerceService commerceService;
	
	@GetMapping
	private ResponseEntity<List<Commerce>> getAllCondition(){
		return ResponseEntity.ok(commerceService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Commerce> saveProdut(@RequestBody Commerce commerce){
		
		try {
			Commerce commerceSave = commerceService.save(commerce);			
			return ResponseEntity.created(new URI("/commerces/"+commerceSave.getId())).body(commerceSave);
			//return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.ok(commerceService.getById(Long.valueOf(commerce.getId())));
		}		
	}
	
	@PutMapping
	private ResponseEntity<Commerce> editProduct(@RequestBody Commerce commerce){
		return this.saveProdut(commerce);
	}
	
	@DeleteMapping(value="delete/{id}")
	private ResponseEntity<Commerce> deleteCommerce(@PathVariable ("id") Long idCommerce){
		Optional<Commerce> commerce = commerceService.findById(idCommerce);
		if(!commerce.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		commerceService.deleteById(idCommerce);
		return ResponseEntity.ok(new Commerce());
		
	}
}
