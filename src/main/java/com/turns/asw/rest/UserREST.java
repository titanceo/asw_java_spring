package com.turns.asw.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.turns.asw.model.User;
import com.turns.asw.model.requestpersonalized.AuthLogin;
import com.turns.asw.model.responsepersonalized.GeneralResp;

@RestController
@RequestMapping("/auth/")
public class UserREST {

	@PostMapping
	private ResponseEntity<GeneralResp> authLogin(@RequestBody User user){
		
		if(user.getUsername().equals("asw") && user.getPassword().equals("123456") ) {
			GeneralResp generalResp = new GeneralResp("200", user.getUsername(), "");
			return ResponseEntity.ok().body(generalResp);
		}else {
			GeneralResp generalResp = new GeneralResp("401", "Credenciales Invalidas", "Credenciales Invalidas");
			return new ResponseEntity<>(generalResp,HttpStatus.UNAUTHORIZED);
		}
		/*
		try {
			return ResponseEntity.ok(userService.login(user.getUsername(), user.getPassword()));
		} catch (Exception e) {
			return null;
		}	*/
	}
}
