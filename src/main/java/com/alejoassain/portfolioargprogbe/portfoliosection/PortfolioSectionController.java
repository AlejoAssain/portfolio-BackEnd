package com.alejoassain.portfolioargprogbe.portfoliosection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sections")
public class PortfolioSectionController {
    @Autowired
    private IPortfolioSectionService psService;

    @GetMapping
    public ResponseEntity<PortfolioSectionResponse> getAllPortfolioSections() {
        return ResponseEntity.ok(psService.getPortfolioSections());
    }

}
