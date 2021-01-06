package com.java4rohit.avtaar.services.impl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.java4rohit.avtaar.services.OtpService;

@Service
public class OtpServiceImpl implements OtpService  {

	private static final Integer EXPIRE_MINS = 3;

	private LoadingCache<String, Integer> otpCache;

	public OtpServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	public int generateOTP(String phoneNo) {

		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(phoneNo, otp);
		return otp;

	}
	public void clearOTP(String key) {
		otpCache.invalidate(key);
	}

	@Override
	public int getOTP(String phoneNo) {
		try {
			return otpCache.get(phoneNo);
			
		} catch (Exception e) {

		return 0;
		}
	}

	

}
