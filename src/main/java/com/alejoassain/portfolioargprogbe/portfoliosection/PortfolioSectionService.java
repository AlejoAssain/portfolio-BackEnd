package com.alejoassain.portfolioargprogbe.portfoliosection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioSectionService implements IPortfolioSectionService {
    @Autowired
    private PortfolioSectionRepository psRepository;

    @Override
    public PortfolioSectionResponse getPortfolioSections() {
        List<PortfolioSection> portfolioSections = psRepository.findAll();
        return PortfolioSectionResponse
                .builder()
                .sections(portfolioSections)
                .build();
    }
}
