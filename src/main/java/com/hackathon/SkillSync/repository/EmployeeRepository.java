package com.hackathon.SkillSync.repository;

import com.hackathon.SkillSync.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
