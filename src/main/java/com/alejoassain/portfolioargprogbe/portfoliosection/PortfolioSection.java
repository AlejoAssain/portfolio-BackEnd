package com.alejoassain.portfolioargprogbe.portfoliosection;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PortfolioSection {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String subtitle;
}
