package com.hackathon.SkillSync.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SkillGapReportResponse {

    private String employeeName;

    private String projectName;

    private List<String> missingSkills;

    private List<String> recommendedCourses;
}
