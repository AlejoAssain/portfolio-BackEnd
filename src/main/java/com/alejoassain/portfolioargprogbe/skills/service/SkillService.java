package com.alejoassain.portfolioargprogbe.skills.service;

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

    private SkillResponse buildResponse(Skill skill) {
        return SkillResponse.builder()
                .sequence(skill.getId())
                .name(skill.getName())
                .description(skill.getDescription())
                .percentage(skill.getPercentage())
                .build();
    }

    @Override
    public SkillsResponse getSkills() {
        List<Skill> skills = skillRepository.findAll();

        SkillsResponse skillsResponse = SkillsResponse.builder()
                .skills(new ArrayList<>())
                .build();

        for (int i = 0; i < skills.size(); i++) {
            Skill skill = skills.get(i);

            skillsResponse.addSkillResponse(this.buildResponse(skill));
        }

        skillsResponse.sortSkillsBySequence();

        return skillsResponse;
    }

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

            skillsResponse.addSkillResponse(this.buildResponse(skill));
        }

        skillsResponse.sortSkillsBySequence();

        return skillsResponse;
    }
}
