package com.rest.mshala.Impl;

import com.rest.mshala.Exception.InvalidUserException;
import com.rest.mshala.UserRepository;
import com.rest.mshala.UserService;
import com.rest.mshala.UserUtil;
import com.rest.mshala.model.Grade;
import com.rest.mshala.model.User;
import com.rest.mshala.model.UserRequest;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @SneakyThrows(InvalidUserException.class)
    @Override
    public User save(UserRequest userRequest) {
        if(userRequest == null || !UserUtil.isValid(userRequest))
            throw new InvalidUserException("Invalid UserRequest");

        User user = new User();
        user.setGrade(Grade.valueOf(userRequest.getGrade()));
        user.setGuardianName(userRequest.getGuardianName());
        user.setMobileNumber(userRequest.getMobileNumber());
        user.setStudentName(userRequest.getStudentName());

        user = userRepository.save(user);
        logger.info("User saved : {} ", user);

        return user;
    }
}
