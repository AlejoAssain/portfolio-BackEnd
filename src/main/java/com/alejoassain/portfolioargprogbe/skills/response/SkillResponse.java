package com.alejoassain.portfolioargprogbe.skills.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SkillResponse {
    private Integer sequence;
    private String name;
    private String description;
    private Integer percentage;
}
