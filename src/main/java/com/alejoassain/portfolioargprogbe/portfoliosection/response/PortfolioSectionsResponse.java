package com.alejoassain.portfolioargprogbe.portfoliosection.response;

import com.alejoassain.portfolioargprogbe.portfoliosection.entity.PortfolioSection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioSectionsResponse {
    private List<PortfolioSection> sections;
}
