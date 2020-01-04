package com.rest.mshala.model;

import lombok.Data;

@Data
public class BaseDTO {
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;
}
