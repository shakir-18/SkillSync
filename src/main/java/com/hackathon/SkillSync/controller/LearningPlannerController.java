package com.hackathon.SkillSync.controller;

import com.hackathon.SkillSync.dto.SkillGapReportResponse;
import com.hackathon.SkillSync.service.LearningPlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LearningPlannerController {

    private final LearningPlannerService learningPlannerService;

    @QueryMapping
    public List<SkillGapReportResponse> skillGapReport(
            @Argument Long projectId) {

        return learningPlannerService.generateSkillGapReport(projectId);
    }
}