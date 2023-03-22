package com.alejoassain.portfolioargprogbe.projects.request;

import lombok.Data;

import java.util.List;

@Data
public class ProjectsRequest {
    List<ProjectRequest> projects;
}
