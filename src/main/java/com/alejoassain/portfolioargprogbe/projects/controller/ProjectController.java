package com.alejoassain.portfolioargprogbe.projects.controller;

import com.alejoassain.portfolioargprogbe.projects.request.ProjectsRequest;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectsResponse;
import com.alejoassain.portfolioargprogbe.projects.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    IProjectService projectService;

    @PostMapping
    ResponseEntity<ProjectsResponse> updateProjectList(
            @RequestBody ProjectsRequest requestBody
    ) {
        return ResponseEntity.ok(projectService.setProjects(requestBody));
    }
}
