package com.naukri.jobportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naukri.jobportal.dto.PortalUser;
import com.naukri.jobportal.repository.PortalUserRepository;

@Repository
public class PortalUserDao {
	@Autowired
	PortalUserRepository userRepository;

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmailAndVerifiedTrue(email);
	}

	public void saveUser(PortalUser portalUser) {
		userRepository.save(portalUser);
	}

	public PortalUser findUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteIfExists(String email) {
		
		
	}

}
