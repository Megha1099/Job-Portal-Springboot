package com.naukri.jobportal.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.naukri.jobportal.helper.AES;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Component

@Data
public class PortalUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 3, max = 15, message = "* Enter between 3~15 charecters")
	private String name;
	@NotEmpty(message = "* this is required field")
	@Email(message = "* Enter Proper Email Format")
	private String email;
	@DecimalMin(value = "6000000000", message = "* Enter Proper Mobile Number")
	@DecimalMax(value = "9999999999", message = "* Enter Proper Mobile Number")
	private long mobile;
	@NotNull(message = "* this is required field")
	private LocalDate dob;
	@Size(min = 8, max = 15, message = "* Enter between 8~15 charecters")
	private String password;
	@Size(min = 8, max = 15, message = "* Enter between 8~15 charecters")
	private String confirm_password;
	@NotNull(message = "* this is required field")
	private String role;
	private int otp;
	private boolean verified;
//	public String getPassword() {
//		return AES.decrypt(password,"123");
//	}
//	public void setPassword(String password) {
//		this.password =AES.encrypt(password, "123");
//	}
	
	

}