package com.alejoassain.portfolioargprogbe.portfoliosection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioSectionRepository extends JpaRepository<PortfolioSection, Integer> {
    Optional<PortfolioSection> findByName(String name);
}
