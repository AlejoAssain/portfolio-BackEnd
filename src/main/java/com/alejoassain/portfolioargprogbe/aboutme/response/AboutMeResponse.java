package com.alejoassain.portfolioargprogbe.aboutme.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AboutMeResponse {
    private String text;
    private String profilePicLink;
    private String profilePicCap;
}
