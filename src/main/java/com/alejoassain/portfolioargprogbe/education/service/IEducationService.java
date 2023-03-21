package com.alejoassain.portfolioargprogbe.education.service;

import com.alejoassain.portfolioargprogbe.education.request.EducationsRequest;
import com.alejoassain.portfolioargprogbe.education.response.EducationsResponse;

public interface IEducationService {
    EducationsResponse setEducations(EducationsRequest requestBody);

}
