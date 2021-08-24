package com.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.models.Contact;
import com.gym.service.ContactService;

@RestController
@RequestMapping("/gym")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactRestController 
{
	@Autowired
	ContactService contactService;
	
	@PostMapping("/sendMessage")
	public ResponseEntity<String> createContact(@RequestBody Contact contact){
		ResponseEntity<String> response = null;
		try {
			Integer id = contactService.saveMessage(contact);
			String body = "Contact '"+id+"' created";
			response = new ResponseEntity<String>(body,	HttpStatus.CREATED);
		}
		catch (Exception e) {
			response =  new ResponseEntity<String>("Unable to Create Contact",HttpStatus.INTERNAL_SERVER_ERROR);
			System.out.println(e);
		}
		return response;
	}
}
