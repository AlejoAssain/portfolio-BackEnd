package com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse;

import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.skills.response.SkillResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@SuperBuilder
public class SkillsSectionResponse extends PortfolioSectionResponse {
    List<SkillResponse> skills;
}
