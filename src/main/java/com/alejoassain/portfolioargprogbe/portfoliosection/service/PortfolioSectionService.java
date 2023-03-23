package com.alejoassain.portfolioargprogbe.portfoliosection.service;

import com.alejoassain.portfolioargprogbe.aboutme.response.AboutMeResponse;
import com.alejoassain.portfolioargprogbe.aboutme.service.IAboutMeService;
import com.alejoassain.portfolioargprogbe.education.response.EducationsResponse;
import com.alejoassain.portfolioargprogbe.education.service.IEducationService;
import com.alejoassain.portfolioargprogbe.experience.response.ExperiencesResponse;
import com.alejoassain.portfolioargprogbe.experience.service.IExperienceService;
import com.alejoassain.portfolioargprogbe.portfoliosection.entity.PortfolioSection;
import com.alejoassain.portfolioargprogbe.portfoliosection.request.PortfolioSectionRequest;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.repository.PortfolioSectionRepository;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.PortfolioSectionsResponse;
import com.alejoassain.portfolioargprogbe.portfoliosection.response.sectionresponse.*;
import com.alejoassain.portfolioargprogbe.projects.response.ProjectsResponse;
import com.alejoassain.portfolioargprogbe.projects.service.IProjectService;
import com.alejoassain.portfolioargprogbe.skills.response.SkillsResponse;
import com.alejoassain.portfolioargprogbe.skills.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PortfolioSectionService implements IPortfolioSectionService {
    @Autowired
    private PortfolioSectionRepository psRepository;

    @Autowired
    private IAboutMeService amService;
    @Autowired
    private ISkillService skillService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IExperienceService experienceService;
    @Autowired
    private IProjectService projectService;

    private BannerSectionResponse getBannerResponse(PortfolioSection bannerSection) {
        return BannerSectionResponse.builder()
                .title(bannerSection.getTitle())
                .subtitle(bannerSection.getSubtitle())
                .build();
    }

    private AboutMeSectionResponse getAboutMeResponse(PortfolioSection aboutMeSection) {
        AboutMeResponse aboutMeData = amService.getAboutMeData();

        return AboutMeSectionResponse.builder()
                .title(aboutMeSection.getTitle())
                .subtitle(aboutMeSection.getSubtitle())
                .text(aboutMeData.getText())
                .profilePicLink(aboutMeData.getProfilePicLink())
                .profilePicCap(aboutMeData.getProfilePicCap())
                .build();
    }

    private SkillsSectionResponse getSkillsResponse(PortfolioSection skillsSection) {
        SkillsResponse skillsData = skillService.getSkills();

        return SkillsSectionResponse.builder()
                .title(skillsSection.getTitle())
                .subtitle(skillsSection.getSubtitle())
                .skills(skillsData.getSkills())
                .build();
    }

    private EducationSectionResponse getEducationResponse(PortfolioSection educationSection) {
        EducationsResponse educationsData = educationService.getEducations();

        return EducationSectionResponse.builder()
                .title(educationSection.getTitle())
                .subtitle(educationSection.getSubtitle())
                .educations(educationsData.getEducations())
                .build();
    }

    private ExperienceSectionResponse getExperienceResponse(PortfolioSection experienceSection) {
        ExperiencesResponse experiencesData = experienceService.getExperiences();

        return ExperienceSectionResponse.builder()
                .title(experienceSection.getTitle())
                .subtitle(experienceSection.getSubtitle())
                .experiences(experiencesData.getExperiences())
                .build();
    }

    private ProjectsSectionResponse getProjectsResponse(PortfolioSection projectsSection) {
        ProjectsResponse projectsData = projectService.getProjects();

        return ProjectsSectionResponse.builder()
                .title(projectsSection.getTitle())
                .subtitle(projectsSection.getSubtitle())
                .projects(projectsData.getProjects())
                .build();
    }


    @Override
    public PortfolioSectionsResponse getPortfolioSections() {
        List<PortfolioSection> portfolioSections = psRepository.findAll();
        Map<String, PortfolioSection> sectionByName = new HashMap<>();

        for (PortfolioSection section : portfolioSections) {
            sectionByName.put(section.getName(), section);
        }

        PortfolioSectionsResponse portfolioSectionsResponse = PortfolioSectionsResponse.builder()
                .banner(this.getBannerResponse(sectionByName.get("banner")))
                .aboutMe(this.getAboutMeResponse(sectionByName.get("about-me")))
                .skills(this.getSkillsResponse(sectionByName.get("skills")))
                .education(this.getEducationResponse(sectionByName.get("education")))
                .experience(this.getExperienceResponse(sectionByName.get("experience")))
                .projects(this.getProjectsResponse(sectionByName.get("projects")))
                .build();

        return portfolioSectionsResponse;
    }

    @Override
    public PortfolioSectionResponse getPortfolioSection(String sectionName) {
        PortfolioSection ps = psRepository.findByName(sectionName).orElse(null);

        return PortfolioSectionResponse.builder()
                .title(ps.getTitle())
                .subtitle(ps.getSubtitle())
                .build();
    }

    @Override
    public PortfolioSectionResponse updatePortfolioSection(String sectionName, PortfolioSectionRequest requestBody) {
        PortfolioSection ps = psRepository.findByName(sectionName).orElse(null);

        requestBody.getTitle().ifPresent(ps::setTitle);
        requestBody.getSubtitle().ifPresent(ps::setSubtitle);

        psRepository.save(ps);

        return PortfolioSectionResponse.builder()
                .title(ps.getTitle())
                .subtitle(ps.getSubtitle())
                .build();
    }
}
