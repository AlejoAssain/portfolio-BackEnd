package com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse;

import com.alejoassain.portfolioargprogbe.education.response.EducationResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class EducationSectionResponse extends PortfolioSectionResponse {
    List<EducationResponse> educations;
}
