package com.alejoassain.portfolioargprogbe.aboutme.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AboutMe {
    @Id
    private Integer id;
    @Column(nullable = false, length = 1000)
    private String text;
    @Column(nullable = false)
    private String profilePicLink;
    @Column(nullable = false)
    private String profilePicCap;
}
