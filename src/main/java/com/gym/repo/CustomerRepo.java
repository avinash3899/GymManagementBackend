package com.gym.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
