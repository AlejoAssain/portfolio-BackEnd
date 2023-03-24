package com.alejoassain.portfolioargprogbe.portfoliosection.controller;


import com.alejoassain.portfolioargprogbe.portfoliosection.request.PortfolioSectionRequest;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionsResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.service.IPortfolioSectionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/section")
public class PortfolioSectionController {
    @Autowired
    private IPortfolioSectionService psService;

    @GetMapping("/initialize-sections")
    public ResponseEntity<String> initializeSections() {
        return ResponseEntity.ok(psService.initializeDatabase());
    }

    @GetMapping
    public ResponseEntity<PortfolioSectionsResponse> getAllPortfolioSections() {
        return ResponseEntity.ok(psService.getPortfolioSections());
    }

    @GetMapping("/{sectionName}")
    public ResponseEntity<PortfolioSectionResponse> getPortfolioSection(
        @PathVariable String sectionName
    ) {
        return ResponseEntity.ok(psService.getPortfolioSection(sectionName));
    }

    @PatchMapping("/{sectionName}")
    public ResponseEntity<PortfolioSectionResponse> updatePortfolioSection(
            @PathVariable String sectionName,
            @RequestBody PortfolioSectionRequest requestBody
    ) {
        return ResponseEntity.ok(psService.updatePortfolioSection(sectionName, requestBody));
    }

}
