package com.excel.project.library_management_system.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "user_id")
    private Long userId;
    private String username;
    private String email;
    private String passwordHash;
    
    @Column(name = "is_patron")
    private Boolean isPatron;

    @Column(name = "is_librarian")
    private Boolean isLibrarian;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private List<CirculationTransaction> circulationTransactions;

    @OneToMany(mappedBy = "user")
    private List<HoldRequests> holdRequests;

    @OneToMany(mappedBy = "user")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user")
    private List<Analytics> analytics;
}