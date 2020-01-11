package com.rest.mshala.Impl;

import com.rest.mshala.CacheService;
import com.rest.mshala.OtpGeneratorService;
import com.rest.mshala.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtpServiceImpl implements OtpService {

    @Autowired
    OtpGeneratorService otpGeneratorService;
    @Autowired
    CacheService cacheService;

    @Override
    public String getOtp(String userName) {
        String otp =  otpGeneratorService.generateOtp(userName);
        cacheService.put(userName, otp);
        return otp;
    }
}
