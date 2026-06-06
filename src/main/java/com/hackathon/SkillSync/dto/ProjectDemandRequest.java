package com.hackathon.SkillSync.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDemandRequest {

    private String projectName;

    private String clientName;

    private Integer requiredResources;

    private List<String> requiredSkills;
}
