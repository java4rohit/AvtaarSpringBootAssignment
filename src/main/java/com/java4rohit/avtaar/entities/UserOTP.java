package com.java4rohit.avtaar.entities;

public class UserOTP   extends GenericEntities {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phoneNo;
	private int otp;
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	
	
	@Override
	public String toString() {
		return "UserOTP [phoneNo=" + phoneNo + ", otp=" + otp + "]";
	}
	
	
	

	
	
	

}
