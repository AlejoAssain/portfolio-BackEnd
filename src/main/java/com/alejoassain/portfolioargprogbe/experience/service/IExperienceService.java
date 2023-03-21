package com.alejoassain.portfolioargprogbe.experience.service;

import com.alejoassain.portfolioargprogbe.experience.request.ExperiencesRequest;
import com.alejoassain.portfolioargprogbe.experience.response.ExperiencesResponse;

public interface IExperienceService {
    ExperiencesResponse setExperiences(ExperiencesRequest requestBody);
}
