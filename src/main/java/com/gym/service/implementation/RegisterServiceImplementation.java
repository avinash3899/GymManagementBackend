package com.gym.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.models.Customer;
import com.gym.repo.CustomerRepo;
import com.gym.service.RegisterService;

@Service
public class RegisterServiceImplementation implements RegisterService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public Integer createCustomer(Customer customer) {
		customer.setIsAdmin("no");
		customerRepo.save(customer);
		return customer.getId();
	}
	
}
