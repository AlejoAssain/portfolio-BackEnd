package com.alejoassain.portfolioargprogbe.aboutme.service;

import com.alejoassain.portfolioargprogbe.aboutme.entity.AboutMe;
import com.alejoassain.portfolioargprogbe.aboutme.repository.AboutMeRepository;
import com.alejoassain.portfolioargprogbe.aboutme.request.AboutMeRequest;
import com.alejoassain.portfolioargprogbe.aboutme.response.AboutMeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutMeService implements IAboutMeService{
    @Autowired
    private AboutMeRepository amRepository;

    @Override
    public AboutMeResponse getAboutMeData() {
        AboutMe am = amRepository.findById(1).orElse(null);

        return AboutMeResponse.builder()
                .text(am.getText())
                .profilePicLink(am.getProfilePicLink())
                .profilePicCap(am.getProfilePicCap())
                .build();
    }

    @Override
    public AboutMeResponse updateAboutMeData(AboutMeRequest requestBody) {
        AboutMe am = amRepository.findById(1).orElse(null);

        if (requestBody.getText() != null) {
            am.setText(requestBody.getText());
        }

        if (requestBody.getProfilePicLink() != null) {
            am.setProfilePicLink(requestBody.getProfilePicLink());
        }

        if (requestBody.getProfilePicCap() != null) {
            am.setProfilePicCap(requestBody.getProfilePicCap());
        }

        amRepository.save(am);

        return AboutMeResponse.builder()
                .text(am.getText())
                .profilePicLink(am.getProfilePicLink())
                .profilePicCap(am.getProfilePicCap())
                .build();
    }
}
