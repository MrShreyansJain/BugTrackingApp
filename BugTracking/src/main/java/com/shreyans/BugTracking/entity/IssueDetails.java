package com.shreyans.BugTracking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    @Column(name = "`description`", length = 2000)
    private String description;

    @Column(name = "`type`", length = 50)
    private String type;

    @Column(length = 50)
    private String priority;
}
