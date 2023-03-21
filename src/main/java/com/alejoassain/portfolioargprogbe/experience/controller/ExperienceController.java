package com.alejoassain.portfolioargprogbe.experience.controller;

import com.alejoassain.portfolioargprogbe.experience.request.ExperiencesRequest;
import com.alejoassain.portfolioargprogbe.experience.response.ExperiencesResponse;
import com.alejoassain.portfolioargprogbe.experience.service.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/experience")
public class ExperienceController {
    @Autowired
    private IExperienceService experienceService;

    @PostMapping
    ResponseEntity<ExperiencesResponse> updateExperienceList(
            @RequestBody ExperiencesRequest requestBody
    ) {
       return ResponseEntity.ok(experienceService.setExperiences(requestBody));
    }
}
