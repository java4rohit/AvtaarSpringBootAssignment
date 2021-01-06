package com.java4rohit.avtaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java4rohit.avtaar.entities.UserOTP;
import com.java4rohit.avtaar.services.OtpService;

@RestController
public class OtpContoller {

	@Autowired
	OtpService otpService;

	@GetMapping(value = "/generateOtp")
	public ResponseEntity<Integer> generateOtp(String phoneNo) {
		int responseotp = otpService.generateOTP(phoneNo);
		return new ResponseEntity<Integer>(responseotp, HttpStatus.OK);

	}

	@RequestMapping(value = "/validateOtp", method = RequestMethod.POST)
	public ResponseEntity<String> validationOtp(UserOTP otp) {

		int serverOtp = otpService.getOTP(otp.getPhoneNo());
		if (serverOtp > 0) {
			if (otp.getOtp() == serverOtp) {
				otpService.clearOTP(otp.getPhoneNo());
				return new ResponseEntity<String>("varification Successful",HttpStatus.OK);
			}

		}
		return  new ResponseEntity<String>("Entered valid Otp",HttpStatus.UNAUTHORIZED);

	}
}
