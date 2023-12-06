package com.SangamOne.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SangamOne.dao.utility.UtilityMethods;
import com.SangamOne.dao1.OtpDao1;
import com.SangamOne.model.Otp;
import com.SangamOne.repository.OtpRepo;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OtpImp implements OtpDao1 {
	@Autowired
	OtpRepo otpRepo;
	
	
	
	@Autowired
	UtilityMethods utilityMethod;


	@Override
	public String addUser(Otp otp) {
		otp.setEmail_id(otp.getEmail_id());
		otp.setUser_name(otp.getUser_name());
		otp.setOtp(utilityMethod.generatedRandomOtp());
		utilityMethod.sendMail(otp.getEmail_id(), otp.getOtp());
		otpRepo.save(otp);
		return "Successfully";
	}
		
}
