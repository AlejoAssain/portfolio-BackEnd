package com.alejoassain.portfolioargprogbe.skills.controller;

import com.alejoassain.portfolioargprogbe.skills.request.SkillsRequest;
import com.alejoassain.portfolioargprogbe.skills.response.SkillsResponse;
import com.alejoassain.portfolioargprogbe.skills.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {
    @Autowired
    private ISkillService skillService;

    @PostMapping
    public ResponseEntity<SkillsResponse> updateSkillList(
            @RequestBody SkillsRequest requestBody
    ) {
        return ResponseEntity.ok(skillService.setSkills(requestBody));
    }
}
