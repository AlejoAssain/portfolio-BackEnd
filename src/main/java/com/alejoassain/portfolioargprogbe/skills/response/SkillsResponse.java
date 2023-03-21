package com.alejoassain.portfolioargprogbe.skills.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@Builder
public class SkillsResponse {
    private List<SkillResponse> skills;

    public void addSkillResponse(SkillResponse skillResponse) {
        this.skills.add(skillResponse);
    }

    public void sortSkillsBySequence() {
        Collections.sort(this.skills, Comparator.comparing(SkillResponse::getSequence));
    }
}
