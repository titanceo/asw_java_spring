package com.turns.asw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turns.asw.model.Commerce;
import com.turns.asw.model.Turn;
import com.turns.asw.service.CommerceService;

import java.net.URI;
import java.util.List;

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
			//return ResponseEntity.created(new URI("/commerces/"+commerceSave.getId())).body(commerceSave);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.ok(commerceService.getById(Long.valueOf(commerce.getId())));
		}		
	}
}
