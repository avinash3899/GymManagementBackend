package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Contact;
import com.gym.repo.ContactRepo;
import com.gym.service.ContactService;

@Service
public class ContactServiceImplementation implements ContactService
{
	@Autowired
	private ContactRepo contactRepo;
	
	@Override
	public Integer saveMessage(Contact message) {
		contactRepo.save(message);
		return message.getId();
	}
}