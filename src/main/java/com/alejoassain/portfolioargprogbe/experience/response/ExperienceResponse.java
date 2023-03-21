package com.alejoassain.portfolioargprogbe.experience.response;

import lombok.Builder;
import lombok.Data;

import java.time.Year;
import java.time.YearMonth;

@Data
@Builder
public class ExperienceResponse {
    private Integer sequence;
    private String companyName;
    private String positionName;
    private String positionInfo;
    private YearMonth yearMonthFrom;
    private YearMonth yearMonthTo;
    private String companyImageLink;
}
