package com.hackathon.SkillSync.service;

import com.hackathon.SkillSync.dto.EmployeeRequest;
import com.hackathon.SkillSync.entity.Employee;
import com.hackathon.SkillSync.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(EmployeeRequest request){

        Employee employee = new Employee();

        employee.setEmployeeId(request.getEmployeeId());
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDesignation(request.getDesignation());
        employee.setExperience(request.getExperience());
        employee.setCurrentProject(request.getCurrentProject());
        employee.setSkills(request.getSkills());

        return employeeRepository.save(employee);
    }
}