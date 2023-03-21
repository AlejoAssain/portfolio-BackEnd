package com.alejoassain.portfolioargprogbe.skills.service;

import com.alejoassain.portfolioargprogbe.skills.request.SkillsRequest;
import com.alejoassain.portfolioargprogbe.skills.response.SkillsResponse;

public interface ISkillService {
    SkillsResponse setSkills(SkillsRequest requestBody);

}
