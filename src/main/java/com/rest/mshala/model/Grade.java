package com.rest.mshala.model;

public enum Grade {
    LKG ("LKG"),
    UKG ("UKG"),
    FIRST("1st"),
    SECOND("2nd"),
    THIRD ("3rd"),
    FOURTH ("4th"),
    FIFTH ("5th"),
    SIXTH ("6th"),
    SEVEN ("7th"),
    EIGHT ("8th"),
    NINETH ("9th"),
    TENTH ("10th"),
    ELEVENTH ("11th"),
    TWELVE ("12th");
    private String level;

    Grade(String grade){
        this.level = grade;
    }

    public String getGrade(){
        return level;
    }

}
