package com.rest.mshala;

import com.rest.mshala.Exception.InvalidUserException;
import com.rest.mshala.model.User;
import com.rest.mshala.model.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    OtpService otpService;
    @Autowired
    CommunicationService<String, String, String> communicationService;
    @Autowired
    UserService userService;
    @Autowired
    CacheService cacheService;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/health")
    public String getHealth(){
        return "is Up";
    }

    @GetMapping("/otp")
    public String generateOtp(@RequestParam String mobileNumber){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String  userName = "dummyUser";
        if(authentication != null)
            userName = authentication.getName();

        String otp = otpService.getOtp(mobileNumber);
        logger.debug("userName : {} otp : {}", userName, otp );
        communicationService.sendMessage("Otp from EduBuzz", "Your otp for logging in is : " + otp , "prasaddongrekar@gmail.com");

        return otp;
    }

    @PostMapping("/verify")
    public boolean verifyOtp(@RequestParam String otp, @RequestParam String mobileNumber){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "dummyUser";

        if(authentication != null)
            userName = authentication.getName();

        return cacheService.verify(mobileNumber, otp);

    }

    @PostMapping("/register")
    public User register(@RequestBody UserRequest userRequest) throws InvalidUserException {
        logger.info("UserRequest : {} ", userRequest);
        if(userRequest == null)
            throw new InvalidUserException("UserRequest is invalid");

        return userService.save(userRequest);
    }



}
