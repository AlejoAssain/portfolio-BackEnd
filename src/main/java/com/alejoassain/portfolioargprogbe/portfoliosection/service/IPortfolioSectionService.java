package com.alejoassain.portfolioargprogbe.portfoliosection.service;

import com.alejoassain.portfolioargprogbe.portfoliosection.entity.PortfolioSection;
import com.alejoassain.portfolioargprogbe.portfoliosection.request.PortfolioSectionRequest;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionsResponse;
import com.alejoassain.portfolioargprogbe.skills.entity.Skill;

import java.util.List;

public interface IPortfolioSectionService {
    public PortfolioSectionsResponse getPortfolioSections();
    public PortfolioSectionResponse getPortfolioSection(String sectionName);
    public PortfolioSectionResponse updatePortfolioSection(String sectionName, PortfolioSectionRequest requestBody);
    public String initializeDatabase();
}
