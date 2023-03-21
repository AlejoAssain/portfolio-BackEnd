package com.alejoassain.portfolioargprogbe.experience.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@Builder
public class ExperiencesResponse {
    private List<ExperienceResponse> experiences;

    public void addExperienceResponse(ExperienceResponse experienceResponse) {
        this.experiences.add(experienceResponse);
    }

    public void sortExperiencesBySequence() {
        Collections.sort(this.experiences, Comparator.comparing(ExperienceResponse::getSequence));
    }
}
