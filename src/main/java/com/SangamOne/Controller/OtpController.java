package com.SangamOne.Controller;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SangamOne.dao1.OtpDao1;
import com.SangamOne.model.Otp;



@RestController
public class OtpController {
	@Autowired
	OtpDao1 otpDao1;
	
	@PostMapping("/addUsers")
	public String addUsers(@RequestBody Otp otp) {
		return otpDao1.addUser(otp);
	}

}
