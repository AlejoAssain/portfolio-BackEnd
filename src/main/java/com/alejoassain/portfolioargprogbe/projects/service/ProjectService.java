package com.alejoassain.portfolioargprogbe.projects.service;

import com.alejoassain.portfolioargprogbe.projects.entity.Project;
import com.alejoassain.portfolioargprogbe.projects.repository.ProjectRepository;
import com.alejoassain.portfolioargprogbe.projects.request.ProjectRequest;
import com.alejoassain.portfolioargprogbe.projects.request.ProjectsRequest;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectResponse;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    private ProjectResponse buildResponse(Project project) {
        return ProjectResponse.builder()
                .sequence(project.getId())
                .name(project.getName())
                .description(project.getDescription())
                .projectYearMonth(project.getProjectYearMonth())
                .projectLink(project.getProjectLink())
                .build();
    }

    @Override
    public ProjectsResponse getProjects() {
        List<Project> projects = projectRepository.findAll();

        ProjectsResponse projectsResponse = ProjectsResponse.builder()
                .projects(new ArrayList<>())
                .build();

        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);

            projectsResponse.addExperienceResponse(this.buildResponse(project));
        }

        projectsResponse.sortExperiencesBySequence();

        return projectsResponse;
    }

    @Override
    public ProjectsResponse setProjects(ProjectsRequest requestBody) {
        List<ProjectRequest> projects = requestBody.getProjects();
        ProjectsResponse projectsResponse = ProjectsResponse.builder()
                .projects(new ArrayList<>())
                .build();

        projectRepository.deleteAll();

        for (int i = 0; i < projects.size(); i++) {
            ProjectRequest projectData = projects.get(i);

            Project project = Project.builder()
                    .id(i)
                    .name(projectData.getName())
                    .description(projectData.getDescription())
                    .projectYearMonth(YearMonth.parse(projectData.getProjectYearMonth()))
                    .projectLink(projectData.getProjectLink())
                    .build();

            projectRepository.save(project);

            projectsResponse.addExperienceResponse(this.buildResponse(project));
        }

        projectsResponse.sortExperiencesBySequence();

        return projectsResponse;
    }
}

