package com.example.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account source;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private Account destination;
}
