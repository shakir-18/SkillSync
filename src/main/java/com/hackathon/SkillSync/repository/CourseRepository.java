package com.hackathon.SkillSync.repository;

import com.hackathon.SkillSync.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByTechnology(String technology);
}
