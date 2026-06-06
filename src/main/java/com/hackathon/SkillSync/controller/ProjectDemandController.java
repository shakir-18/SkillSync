package com.hackathon.SkillSync.controller;

import com.hackathon.SkillSync.dto.ProjectDemandRequest;
import com.hackathon.SkillSync.entity.ProjectDemand;
import com.hackathon.SkillSync.service.ProjectDemandService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProjectDemandController {

    private final ProjectDemandService projectDemandService;

    @MutationMapping
    public ProjectDemand createProject(
            @Argument ProjectDemandRequest request) {

        return projectDemandService.create(request);
    }
}