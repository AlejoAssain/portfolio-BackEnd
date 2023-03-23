package com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse;

import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class AboutMeSectionResponse extends PortfolioSectionResponse {
    private String text;
    private String profilePicLink;
    private String profilePicCap;
}
