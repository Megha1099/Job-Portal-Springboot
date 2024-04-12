package com.naukri.jobportal.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApplicantDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String[] skills;
	private String highestEducation;
	private double percentage10; 
	private double percentage12;
	private double percentageDegree;
	private double percentageMasters;
	private String resumePath;

}





