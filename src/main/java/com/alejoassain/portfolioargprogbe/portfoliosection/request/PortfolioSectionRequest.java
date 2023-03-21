package com.alejoassain.portfolioargprogbe.portfoliosection.request;

import lombok.Data;

import java.util.Optional;

@Data
public class PortfolioSectionRequest {
    private Optional<String> title = Optional.empty();
    private Optional<String> subtitle = Optional.empty();
}
