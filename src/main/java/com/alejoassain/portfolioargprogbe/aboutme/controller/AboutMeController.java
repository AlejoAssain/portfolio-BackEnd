package com.alejoassain.portfolioargprogbe.aboutme.controller;

import com.alejoassain.portfolioargprogbe.aboutme.request.AboutMeRequest;
import com.alejoassain.portfolioargprogbe.aboutme.response.AboutMeResponse;
import com.alejoassain.portfolioargprogbe.aboutme.service.IAboutMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/about-me")
public class AboutMeController {
    @Autowired
    private IAboutMeService amService;

    @PatchMapping
    ResponseEntity<AboutMeResponse> updateAboutMeData(
            @RequestBody AboutMeRequest requestBody
    ) {
        return ResponseEntity.ok(amService.setAboutMeData(requestBody));
    }
}
