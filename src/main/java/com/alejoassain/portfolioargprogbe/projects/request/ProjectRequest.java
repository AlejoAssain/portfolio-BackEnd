package com.alejoassain.portfolioargprogbe.projects.request;

import lombok.Data;

@Data
public class ProjectRequest {
    private String name;
    private String description;
    private String projectYearMonth;
    private String projectLink;
}
