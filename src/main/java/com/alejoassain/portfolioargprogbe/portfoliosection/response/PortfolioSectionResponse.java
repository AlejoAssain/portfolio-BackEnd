package com.alejoassain.portfolioargprogbe.portfoliosection.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioSectionResponse {
    private String title;
    private String subtitle;
}
