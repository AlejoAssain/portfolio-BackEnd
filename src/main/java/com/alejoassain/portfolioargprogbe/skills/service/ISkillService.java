package com.alejoassain.portfolioargprogbe.skills.service;

import com.alejoassain.portfolioargprogbe.skills.entity.Skill;
import com.alejoassain.portfolioargprogbe.skills.request.SkillsRequest;
import com.alejoassain.portfolioargprogbe.skills.response.SkillResponse;
import com.alejoassain.portfolioargprogbe.skills.response.SkillsResponse;

public interface ISkillService {
    SkillsResponse getSkills();
    SkillsResponse setSkills(SkillsRequest requestBody);

}
