package com.alejoassain.portfolioargprogbe.education.service;

import com.alejoassain.portfolioargprogbe.education.entity.Education;
import com.alejoassain.portfolioargprogbe.education.repository.EducationRepository;
import com.alejoassain.portfolioargprogbe.education.request.EducationRequest;
import com.alejoassain.portfolioargprogbe.education.request.EducationsRequest;
import com.alejoassain.portfolioargprogbe.education.response.EducationResponse;
import com.alejoassain.portfolioargprogbe.education.response.EducationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
public class EducationService implements IEducationService {
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public EducationsResponse setEducations(EducationsRequest requestBody) {
        List<EducationRequest> educations = requestBody.getEducations();
        EducationsResponse educationsResponse = EducationsResponse.builder()
                .educations(new ArrayList<>())
                .build();

        educationRepository.deleteAll();

        for (int i = 0; i < educations.size(); i++) {
            EducationRequest educationData = educations.get(i);

            Education.EducationBuilder educationBuilder = Education.builder()
                    .id(i)
                    .institutionName(educationData.getInstitutionName())
                    .title(educationData.getTitle())
                    .yearFrom(Year.parse(educationData.getYearFrom()));

            if (educationData.getYearTo() != null) {
                educationBuilder.yearTo(Year.parse(educationData.getYearTo()));
            }

            if (educationData.getInstitutionImageLink() != null) {
                educationBuilder.institutionImageLink(educationData.getInstitutionImageLink());
            }

            Education education = educationBuilder.build();
            educationRepository.save(education);

            educationsResponse.addEducationResponse(EducationResponse.builder()
                    .sequence(i)
                    .institutionName(education.getInstitutionName())
                    .title(education.getTitle())
                    .yearTo(education.getYearTo())
                    .yearFrom(education.getYearFrom())
                    .institutionImageLink(education.getInstitutionImageLink())
                    .build());
        }

        return educationsResponse;
    }
}

