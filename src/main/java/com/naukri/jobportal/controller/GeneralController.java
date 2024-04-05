package com.naukri.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.naukri.jobportal.dto.PortalUser;
import com.naukri.jobportal.service.PortalUserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GeneralController {
	@Autowired
	PortalUser portalUser;

	@Autowired
	PortalUserService userService;

	@GetMapping("/")
	public String loadHome() {
		System.out.println("Control- / , Homepage is displayer");
		return "home.html";
	}

	@GetMapping("/login")
	public String loadLogin() {
		System.out.println("Control- /login , Login Page is displayer");
		return "login.html";
	}

	@GetMapping("/signup")
	public String loadSignup(ModelMap map) {
		System.out.println("Control- /signup - Get , Empty Object is Sent to Signup Page");
		map.put("portalUser", portalUser);
		return "signup.html";
	}

	@PostMapping("/signup")
	public String signup(@Valid PortalUser portalUser, BindingResult result, ModelMap map) {
		System.out.println("Control- /signup - Post , Recieved Post Request");
		return userService.signup(portalUser, result, map);
	}

	@PostMapping("/submit-otp")
	public String submitOtp(@RequestParam int otp, @RequestParam int id, ModelMap map) {
		System.out.println("Control - /submit-otp Get , Recieved otp");
		return userService.submitOtp(otp, id, map);
	}
	@GetMapping("/resend-otp/{id}")///resend-otp?id=5
	public String resendOtp(@PathVariable int id, ModelMap map)
	{
		return userService.resendOtp(id,map);
	}
	@PostMapping("/login")
	public String login(@RequestParam("email-phone") String emph, @RequestParam String password, ModelMap map, HttpSession session)
	{
		return userService.login(emph,password,map,session);
	}
	

}
