package com.gym.service.implementation;

import javax.validation.ConstraintViolationException;

import org.hibernate.HibernateException;
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
		customerRepo.save(customer);
		return customer.getId();
	}
	
}
