package com.asigra.dsclientservice.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="transaction")
public class Transaction implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="backupset_id", referencedColumnName = "id")
    private BackupSet backupSet;

    @Column(name="user_id")
    private Long userId;

    @Column(name="date_of_operation")
    private LocalDateTime dateOfOperation;
}