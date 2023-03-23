package com.alejoassain.portfolioargprogbe.portfoliosection.response;

import com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PortfolioSectionsResponse {
    private BannerSectionResponse banner;
    private AboutMeSectionResponse aboutMe;
    private SkillsSectionResponse skills;
    private EducationSectionResponse education;
    private ExperienceSectionResponse experience;
    private ProjectsSectionResponse projects;
}
