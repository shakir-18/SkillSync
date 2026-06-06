package com.hackathon.SkillSync.service;

import com.hackathon.SkillSync.dto.SkillGapReportResponse;
import com.hackathon.SkillSync.entity.Employee;
import com.hackathon.SkillSync.entity.ProjectDemand;
import com.hackathon.SkillSync.repository.CourseRepository;
import com.hackathon.SkillSync.repository.EmployeeRepository;
import com.hackathon.SkillSync.repository.ProjectDemandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LearningPlannerService {

    private final EmployeeRepository employeeRepository;
    private final ProjectDemandRepository projectRepository;
    private final CourseRepository courseRepository;

    public List<SkillGapReportResponse>
    generateSkillGapReport(Long projectId) {

        ProjectDemand project =
                projectRepository.findById(projectId)
                        .orElseThrow();

        List<Employee> employees =
                employeeRepository.findAll();

        List<SkillGapReportResponse> reports =
                new ArrayList<>();

        for (Employee employee : employees) {

            List<String> missingSkills =
                    project.getRequiredSkills()
                            .stream()
                            .filter(skill ->
                                    !employee.getSkills()
                                            .contains(skill))
                            .toList();

            if (!missingSkills.isEmpty()) {

                List<String> courses =
                        missingSkills.stream()
                                .map(skill ->
                                        courseRepository
                                                .findByTechnology(skill))
                                .filter(list ->
                                        !list.isEmpty())
                                .map(list ->
                                        list.get(0)
                                                .getCourseName())
                                .toList();

                reports.add(
                        SkillGapReportResponse.builder()
                                .employeeName(employee.getName())
                                .projectName(project.getProjectName())
                                .missingSkills(missingSkills)
                                .recommendedCourses(courses)
                                .build()
                );
            }
        }

        return reports;
    }
}
