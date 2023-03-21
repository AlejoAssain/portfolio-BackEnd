package com.alejoassain.portfolioargprogbe.education.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Education {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String institutionName;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Year yearFrom;
    private Year yearTo;
    private String institutionImageLink;
}
