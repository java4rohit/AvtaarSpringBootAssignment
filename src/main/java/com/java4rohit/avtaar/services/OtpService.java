package com.java4rohit.avtaar.services;

public interface OtpService {
	
	
	public int generateOTP(String key);
	
	public int getOTP(String phoneNo);
	
	public void clearOTP(String phoneNo);

}
