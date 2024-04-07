package com.naukri.jobportal.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ApplicantDetails {
@Id
private int id;
private String skills;
private String education;
private String resume;

}
