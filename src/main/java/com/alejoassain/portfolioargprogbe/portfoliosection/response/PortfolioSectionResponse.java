package com.alejoassain.portfolioargprogbe.portfoliosection.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PortfolioSectionResponse {
    private String title;
    private String subtitle;
}
