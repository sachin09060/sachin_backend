package com.excel.project.library_management_system.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "circulation_transaction")
public class CirculationTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private Materials material;

    @Column(name = "transaction_type")
    private String transactionType;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "transaction_date")
    private Date transactionDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "is_returned")
    private Boolean returned;

    @Column(name = "is_renewed")
    private Boolean renewed;


}