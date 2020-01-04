package com.rest.mshala;

import org.springframework.stereotype.Service;

@Service
public interface OtpService {

    String getOtp(String userName);

}
