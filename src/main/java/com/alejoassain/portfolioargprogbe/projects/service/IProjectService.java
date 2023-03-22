package com.alejoassain.portfolioargprogbe.projects.service;

import com.alejoassain.portfolioargprogbe.projects.request.ProjectsRequest;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectsResponse;

public interface IProjectService {
    ProjectsResponse getProjects();
    ProjectsResponse setProjects(ProjectsRequest requestBody);
}
