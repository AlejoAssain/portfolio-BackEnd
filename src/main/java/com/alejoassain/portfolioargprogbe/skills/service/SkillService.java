package com.alejoassain.portfolioargprogbe.skills.service;

import com.alejoassain.portfolioargprogbe.portfoliosection.entity.PortfolioSection;
import com.alejoassain.portfolioargprogbe.portfoliosection.service.IPortfolioSectionService;
import com.alejoassain.portfolioargprogbe.skills.entity.Skill;
import com.alejoassain.portfolioargprogbe.skills.repository.SkillRepository;
import com.alejoassain.portfolioargprogbe.skills.request.SkillRequest;
import com.alejoassain.portfolioargprogbe.skills.request.SkillsRequest;
import com.alejoassain.portfolioargprogbe.skills.response.SkillResponse;
import com.alejoassain.portfolioargprogbe.skills.response.SkillsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public SkillsResponse setSkills(SkillsRequest requestBody) {
        List<SkillRequest> skills = requestBody.getSkills();
        SkillsResponse skillsResponse = SkillsResponse.builder()
                .skills(new ArrayList<>())
                .build();

        skillRepository.deleteAll();

        for (int i = 0; i < skills.size(); i++) {
            SkillRequest skillData = skills.get(i);

            Skill skill = Skill.builder()
                    .id(i)
                    .name(skillData.getName())
                    .description(skillData.getDescription())
                    .percentage(skillData.getPercentage())
                    .build();

            skillRepository.save(skill);

            skillsResponse.addSkillResponse(SkillResponse.builder()
                    .sequence(skill.getId())
                    .name(skill.getName())
                    .description(skill.getDescription())
                    .percentage(skill.getPercentage())
                    .build());
        }

        skillsResponse.sortSkillsBySequence();

        return skillsResponse;
    }
}
