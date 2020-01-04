package com.rest.mshala.Impl;

import com.rest.mshala.OtpGeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpGeneratorServiceImpl implements OtpGeneratorService {

    private static final Logger logger = LoggerFactory.getLogger(OtpGeneratorServiceImpl.class);

    private static final Random random = new Random();

    @Override
    public String generateOtp(String userName) {
        String otp = String.format("%04d", random.nextInt(10000));
        logger.debug("User : {} , otp : {} ", userName, otp);

        return otp;
    }
}
