package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.LoginService;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String[] loginvalidate(String email, String password) {
		Customer customer = customerRepo.fetchCustomerByEmail(email);
		String[] reply = null;
		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				
				return reply;
			} else {
				
				return reply;
			}
		} else {
			
			return reply;
		}
	}
}
