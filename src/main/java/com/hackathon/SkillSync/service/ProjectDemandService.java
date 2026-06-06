package com.hackathon.SkillSync.service;

import com.hackathon.SkillSync.dto.ProjectDemandRequest;
import com.hackathon.SkillSync.entity.ProjectDemand;
import com.hackathon.SkillSync.repository.ProjectDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectDemandService {

    private final ProjectDemandRepository projectRepository;

    public ProjectDemand create(ProjectDemandRequest request){

        ProjectDemand project = ProjectDemand.builder()
                .projectName(request.getProjectName())
                .clientName(request.getClientName())
                .requiredResources(request.getRequiredResources())
                .requiredSkills(request.getRequiredSkills())
                .build();

        return projectRepository.save(project);
    }
}