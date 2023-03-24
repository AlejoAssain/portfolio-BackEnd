package com.alejoassain.portfolioargprogbe.aboutme.service;

import com.alejoassain.portfolioargprogbe.aboutme.entity.AboutMe;
import com.alejoassain.portfolioargprogbe.aboutme.request.AboutMeRequest;
import com.alejoassain.portfolioargprogbe.aboutme.response.AboutMeResponse;

public interface IAboutMeService {
    AboutMeResponse getAboutMeData();
    AboutMeResponse setAboutMeData(AboutMeRequest requestBody);
    public void generateDefaultAboutMeData();
}
