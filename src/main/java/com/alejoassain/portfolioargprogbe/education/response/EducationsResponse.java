package com.alejoassain.portfolioargprogbe.education.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@Builder
public class EducationsResponse {
    private List<EducationResponse> educations;

    public void addEducationResponse(EducationResponse educationResponse) {
        this.educations.add(educationResponse);
    }

    public void sortEducationsBySequence() {
        Collections.sort(this.educations, Comparator.comparing(EducationResponse::getSequence));
    }
}
