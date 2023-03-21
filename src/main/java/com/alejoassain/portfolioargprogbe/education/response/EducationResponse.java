package com.alejoassain.portfolioargprogbe.education.response;

import lombok.Builder;
import lombok.Data;

import java.time.Year;

@Data
@Builder
public class EducationResponse {
    private Integer sequence;
    private String institutionName;
    private String title;
    private Year yearFrom;
    private Year yearTo;
    private String institutionImageLink;
}
