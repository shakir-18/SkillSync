package com.hackathon.SkillSync.controller;

import com.hackathon.SkillSync.dto.EmployeeRequest;
import com.hackathon.SkillSync.entity.Employee;
import com.hackathon.SkillSync.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @MutationMapping
    public Employee addEmployee(@Argument EmployeeRequest request) {
        return employeeService.save(request);
    }
}
