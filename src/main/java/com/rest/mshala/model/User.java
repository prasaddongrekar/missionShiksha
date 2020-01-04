package com.rest.mshala.model;

import lombok.Data;

@Data
public class User extends BaseDTO {

    private String studentName;
    private String guardianName;
    private String mobileNumber;
    private Grade grade;

}
