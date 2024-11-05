package com.excel.project.library_management_system.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "materials")
public class Materials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialId;

    private String title;
    private String author;
    private String category;
    private String description;
    private String isbn;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "total_copies")
    private Integer totalCopies;

    @Column(name = "available_copies")
    private Integer availableCopies;

    @OneToMany(mappedBy = "material")
    private List<CirculationTransaction> circulationTransactions;

    @OneToMany(mappedBy = "material")
    private List<HoldRequests> holdRequests;

    @OneToMany(mappedBy = "material")
    private List<Analytics> analytics;
}
