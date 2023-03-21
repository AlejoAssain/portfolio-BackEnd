package com.alejoassain.portfolioargprogbe.portfoliosection.service;

import com.alejoassain.portfolioargprogbe.portfoliosection.entity.PortfolioSection;
import com.alejoassain.portfolioargprogbe.portfoliosection.request.PortfolioSectionRequest;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.repository.PortfolioSectionRepository;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioSectionService implements IPortfolioSectionService {
    @Autowired
    private PortfolioSectionRepository psRepository;

    @Override
    public PortfolioSectionsResponse getPortfolioSections() {
        List<PortfolioSection> portfolioSections = psRepository.findAll();
        return PortfolioSectionsResponse
                .builder()
                .sections(portfolioSections)
                .build();
    }

    @Override
    public PortfolioSectionResponse getPortfolioSection(String sectionName) {
        PortfolioSection ps = psRepository.findByName(sectionName).orElse(null);
        return PortfolioSectionResponse.builder()
                .title(ps.getTitle())
                .subtitle(ps.getSubtitle())
                .build();
    }

    @Override
    public PortfolioSectionResponse updatePortfolioSection(String sectionName, PortfolioSectionRequest requestBody) {
        PortfolioSection ps = psRepository.findByName(sectionName).orElse(null);

        requestBody.getTitle().ifPresent(ps::setTitle);
        requestBody.getSubtitle().ifPresent(ps::setSubtitle);

        psRepository.save(ps);

        return PortfolioSectionResponse.builder()
                .title(ps.getTitle())
                .subtitle(ps.getSubtitle())
                .build();
    }

    @Override
    public PortfolioSection getPortfolioSectionObject(String sectionName) {
        PortfolioSection section = psRepository.findByName(sectionName).orElse(null);
        return section;
    }
}
