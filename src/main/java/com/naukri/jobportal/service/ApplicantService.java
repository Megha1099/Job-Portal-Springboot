package com.naukri.jobportal.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.naukri.jobportal.dao.PortalUserDao;
import com.naukri.jobportal.dto.ApplicantDetails;
import com.naukri.jobportal.dto.PortalUser;

import jakarta.servlet.http.HttpSession;

@Service
public class ApplicantService {

	@Autowired
	PortalUserDao userDao;

	public String completeProfile(ApplicantDetails details, MultipartFile resume, HttpSession session, ModelMap map) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			
			String resumePath = uploadToCloudinary(resume);// Get from cloudinary
			details.setResumePath(resumePath);
			portalUser.setApplicantDetails(details);
			portalUser.setProfileComplete(true);
			userDao.saveUser(portalUser);
			map.put("msg", "Profile is Completed");
			return "applicant-home.html";
		}
	}
		public String uploadToCloudinary(MultipartFile file)
		{
			
			Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			  "cloud_name", "dfh4fflgt",
			  "api_key", "264444843311252",
			  "api_secret", "pxVzrt0ncXjfl9yYxmZLRVc52V4"));
			Map resume=null;
			try {
				resume=cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
						 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (String) resume.get("url");
			
		
		
	}

	

}
