package com.turns.asw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.turns.asw.model.Commerce;
import com.turns.asw.model.Servicee;
import com.turns.asw.model.responsepersonalized.GeneralResp;
import com.turns.asw.service.ServiceeService;

@RestController
@RequestMapping("/services/")
public class ServiceeREST {


	@Autowired
	private ServiceeService serviceService;
	
	@GetMapping
	private ResponseEntity<List<Servicee>> getAllElaboration(){
		return ResponseEntity.ok(serviceService.findAll());
	}
	
	@GetMapping(value="/{id}")
	private ResponseEntity<List<Servicee>> getAllElaboration(@PathVariable ("id") Long idCommerce){
		return ResponseEntity.ok(serviceService.findByCommerce(idCommerce));
	}
	
	@PostMapping
	private ResponseEntity<Servicee> saveProdut(@RequestBody Servicee servicee){
		
		try {
			Servicee serviceSave = serviceService.save(servicee);			
			return ResponseEntity.created(new URI("/services/"+serviceSave.getId())).body(serviceSave);
		} catch (Exception e) {
			return ResponseEntity.ok(serviceService.getById(Long.valueOf(servicee.getId())));
		}		
	}
	
	@PutMapping
	private ResponseEntity<Servicee> editService(@RequestBody Servicee servicee){
		return this.saveProdut(servicee);
	}
	
	@DeleteMapping(value="delete/{id}")
	private ResponseEntity<?> deleteService(@PathVariable ("id") Long idService){
		Optional<Servicee> service = serviceService.findById(idService);
		try {
			
			if(!service.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			serviceService.deleteById(idService);
			return ResponseEntity.ok(new Servicee());
		} catch (Exception e) {
			GeneralResp generalResp = new GeneralResp("500", e.getCause().toString(), e.getMessage());
			//return new ResponseEntity<GeneralResp>(generalResp,null,HttpStatus.INTERNAL_SERVER_ERROR);
			return ResponseEntity.internalServerError().body(generalResp);
		}		
		
	}
}
