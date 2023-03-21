package com.alejoassain.portfolioargprogbe.experience.request;

import lombok.Data;

@Data
public class ExperienceRequest {
    private String companyName;
    private String positionName;
    private String positionInfo;
    private String yearMonthFrom;
    private String yearMonthTo;
    private String companyImageLink;
}
