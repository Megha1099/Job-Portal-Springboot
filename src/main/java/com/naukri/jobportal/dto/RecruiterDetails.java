package com.naukri.jobportal.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class RecruiterDetails {
	@Id
	private int id;
	private String companyName;
	private String address;
	private String aboutComany;
	private String licence;

}
