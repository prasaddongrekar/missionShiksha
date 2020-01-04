package com.rest.mshala;


import com.rest.mshala.model.UserRequest;
import org.apache.commons.lang3.StringUtils;

public class UserUtil {

    public static boolean isValid(UserRequest userRequest){
        if(userRequest == null || StringUtils.isBlank(userRequest.getGrade()) || StringUtils.isBlank(userRequest.getGuardianName())
                || StringUtils.isBlank(userRequest.getMobileNumber()) || StringUtils.isBlank(userRequest.getStudentName()))
            return false;
        return true;
    }

}
