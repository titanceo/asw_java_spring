package com.turns.asw.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import com.turns.asw.model.Service;
import com.turns.asw.service.ServiceService;

@RestController
@RequestMapping("/services/")
public class ServiceREST {

	@Autowired
	private ServiceService serviceService;
	
	@GetMapping
	private ResponseEntity<List<Service>> getAllElaboration(){
		return ResponseEntity.ok(serviceService.findAll());
	}
	
	@PostMapping
	private ResponseEntity<Service> saveProdut(@RequestBody Service service){
		
		try {
			Service serviceSave = serviceService.save(service);			
			return ResponseEntity.created(new URI("/services/"+serviceSave.getId())).body(serviceSave);
			//return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.ok(serviceService.getById(Long.valueOf(service.getId())));
		}		
	}
}
