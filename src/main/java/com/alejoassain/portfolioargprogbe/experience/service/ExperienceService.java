package com.alejoassain.portfolioargprogbe.experience.service;

import com.alejoassain.portfolioargprogbe.experience.entity.Experience;
import com.alejoassain.portfolioargprogbe.experience.repository.ExperienceRepository;
import com.alejoassain.portfolioargprogbe.experience.request.ExperienceRequest;
import com.alejoassain.portfolioargprogbe.experience.request.ExperiencesRequest;
import com.alejoassain.portfolioargprogbe.experience.response.ExperienceResponse;
import com.alejoassain.portfolioargprogbe.experience.response.ExperiencesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService implements IExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public ExperiencesResponse setExperiences(ExperiencesRequest requestBody) {
        List<ExperienceRequest> experiences = requestBody.getExperiences();
        ExperiencesResponse experiencesResponse = ExperiencesResponse.builder()
                .experiences(new ArrayList<>())
                .build();

        experienceRepository.deleteAll();

        for (int i = 0; i < experiences.size(); i++) {
            ExperienceRequest experienceData = experiences.get(i);

            Experience.ExperienceBuilder experienceBuilder = Experience.builder()
                    .id(i)
                    .companyName(experienceData.getCompanyName())
                    .positionName(experienceData.getPositionName())
                    .positionInfo(experienceData.getPositionInfo())
                    .yearMonthFrom(YearMonth.parse(experienceData.getYearMonthFrom()));

            if (experienceData.getYearMonthTo() != null) {
                experienceBuilder.yearMonthTo(YearMonth.parse(experienceData.getYearMonthTo()));
            }

            if (experienceData.getCompanyImageLink() != null) {
                experienceBuilder.companyImageLink(experienceData.getCompanyImageLink());
            }

            Experience experience = experienceBuilder.build();

            experienceRepository.save(experience);

            experiencesResponse.addExperienceResponse(ExperienceResponse.builder()
                    .sequence(i)
                    .companyName(experience.getCompanyName())
                    .positionName(experience.getPositionName())
                    .positionInfo(experience.getPositionInfo())
                    .yearMonthFrom(experience.getYearMonthFrom())
                    .yearMonthTo(experience.getYearMonthTo())
                    .companyImageLink(experience.getCompanyImageLink())
                    .build());
        }

        experiencesResponse.sortExperiencesBySequence();

        return experiencesResponse;
    }
}

