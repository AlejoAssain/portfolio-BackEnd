package com.alejoassain.portfolioargprogbe.experience.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Experience {
    @Id
    private Integer id;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private String positionName;
    @Column(nullable = false, length = 1000)
    private String positionInfo;
    @Column(nullable = false)
    private YearMonth yearMonthFrom;
    private YearMonth yearMonthTo;
    private String companyImageLink;
}
