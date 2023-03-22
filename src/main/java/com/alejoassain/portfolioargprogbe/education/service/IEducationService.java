package com.alejoassain.portfolioargprogbe.education.service;

import com.alejoassain.portfolioargprogbe.education.entity.Education;
import com.alejoassain.portfolioargprogbe.education.request.EducationsRequest;
import com.alejoassain.portfolioargprogbe.education.response.EducationResponse;
import com.alejoassain.portfolioargprogbe.education.response.EducationsResponse;

public interface IEducationService {
    EducationsResponse getEducations();
    EducationsResponse setEducations(EducationsRequest requestBody);

}
