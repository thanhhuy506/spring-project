package com.example.polls.utility.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.repository.RoleRepository;

@Service
public class UitilityService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@PostConstruct
	void initModel() {
		for(RoleName roleName : RoleName.values()) {
			if(!roleRepository.findByName(roleName).isPresent()) {
				Role role =  new Role();
				role.setName(roleName);
				roleRepository.save(role);
			}
		}
	}
}
