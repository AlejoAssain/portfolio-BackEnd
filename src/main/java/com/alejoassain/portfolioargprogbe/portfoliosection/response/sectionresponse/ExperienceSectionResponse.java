package com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse;

import com.alejoassain.portfolioargprogbe.experience.response.ExperienceResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class ExperienceSectionResponse extends PortfolioSectionResponse {
    List<ExperienceResponse> experiences;
}
