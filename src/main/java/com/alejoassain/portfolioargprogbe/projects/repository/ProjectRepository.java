package com.alejoassain.portfolioargprogbe.projects.repository;

import com.alejoassain.portfolioargprogbe.projects.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
