package com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse;

import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class ProjectsSectionResponse extends PortfolioSectionResponse {
    List<ProjectResponse> projects;
}
