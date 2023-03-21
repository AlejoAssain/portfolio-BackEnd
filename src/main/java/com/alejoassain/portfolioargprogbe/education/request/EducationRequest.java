package com.alejoassain.portfolioargprogbe.education.request;

import lombok.Data;

@Data
public class EducationRequest {
    private String institutionName;
    private String title;
    private String yearFrom;
    private String yearTo;
    private String institutionImageLink;
}
