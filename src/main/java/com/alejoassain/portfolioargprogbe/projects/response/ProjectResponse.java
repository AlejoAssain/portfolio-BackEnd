package com.alejoassain.portfolioargprogbe.projects.response;

import lombok.Builder;
import lombok.Data;

import java.time.YearMonth;

@Data
@Builder
public class ProjectResponse {
    private Integer sequence;
    private String name;
    private String description;
    private YearMonth projectYearMonth;
    private String projectLink;

}
