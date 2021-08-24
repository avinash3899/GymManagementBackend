package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Customer;
import com.gym.service.RegisterService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterCustomerRestController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
		ResponseEntity<String> response = null;
		try {
			Integer id = registerService.createCustomer(customer);
			String body = "Customer '"+id+"' created";
			response = new ResponseEntity<String>(body,	HttpStatus.CREATED);
		}
		catch (Exception e) {
			response =  new ResponseEntity<String>("Unable to Create Student",HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return response;
	}
	
}
