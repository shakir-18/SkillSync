package com.hackathon.SkillSync.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeRequest {

    private String employeeId;
    private String name;
    private String email;
    private String designation;
    private Integer experience;
    private String currentProject;
    private List<String> skills;

}