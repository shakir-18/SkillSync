package com.hackathon.SkillSync.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDemand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String clientName;

    private Integer requiredResources;

    @ElementCollection
    private List<String> requiredSkills;

    private LocalDate expectedStartDate;
}