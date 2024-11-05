package com.excel.project.library_management_system.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "account_details")
public class AccountDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String address;
    private String phone;

    @Column(name = "fine_amount")
    private Double fineAmount;

    @Column(name = "fine_paid_status")
    private Boolean finePaidStatus;
}
