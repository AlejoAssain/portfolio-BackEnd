package com.alejoassain.portfolioargprogbe.projects.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@Builder
public class ProjectsResponse {
    private List<ProjectResponse> projects;

    public void addExperienceResponse(ProjectResponse projectResponse) {
        this.projects.add(projectResponse);
    }

    public void sortExperiencesBySequence() {
        Collections.sort(this.projects, Comparator.comparing(ProjectResponse::getSequence));
    }
}
