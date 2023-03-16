package com.alejoassain.portfolioargprogbe.portfoliosection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioSectionResponse {
    private List<PortfolioSection> sections;
}
