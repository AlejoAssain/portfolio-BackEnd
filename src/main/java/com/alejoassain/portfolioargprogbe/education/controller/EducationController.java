package com.alejoassain.portfolioargprogbe.education.controller;

import com.alejoassain.portfolioargprogbe.education.request.EducationsRequest;
import com.alejoassain.portfolioargprogbe.education.response.EducationsResponse;
import com.alejoassain.portfolioargprogbe.education.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/education")
public class EducationController {
    @Autowired
    private IEducationService educationService;

    @PostMapping
    ResponseEntity<EducationsResponse> updateEducationList(
            @RequestBody EducationsRequest requestBody
    ) {
        return ResponseEntity.ok(educationService.setEducations(requestBody));
    }
}
