package com.hackathon.SkillSync.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "market_trends")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketTrend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technology;

    private Double trendScore;
}

