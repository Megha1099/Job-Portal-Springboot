package com.naukri.jobportal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naukri.jobportal.dto.RecruiterDetails;
import com.naukri.jobportal.service.RecruiterService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	RecruiterService recruiterService;

	@GetMapping("/complete-profile")
	public String completeProfile(ModelMap map, HttpSession session) {
		return recruiterService.checkProfile(map, session);
	}

	@PostMapping("/complete-profile")
	public String completeProfile(RecruiterDetails details, HttpSession session, ModelMap map) {
		return recruiterService.saveRecruiterDetails(details, session, map);
	}
}