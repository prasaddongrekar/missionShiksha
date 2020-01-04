package com.rest.mshala.model;

import lombok.Data;

@Data
public class UserRequest {

    private String studentName;
    private String guardianName;
    private String grade;
    private String mobileNumber;

}
