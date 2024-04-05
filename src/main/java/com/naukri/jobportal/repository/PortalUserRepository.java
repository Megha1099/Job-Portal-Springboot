package com.naukri.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;

import com.naukri.jobportal.dto.PortalUser;

public interface PortalUserRepository extends JpaRepository <PortalUser,Integer>
{
	boolean existsByEmail(String email);

	boolean existsByEmailAndVerifiedTrue(String email);

	PortalUser findByMobile(long mobile);

	PortalUser findByEmail(String email);

}
