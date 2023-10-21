package com.example.tutorial.entity;

import com.example.tutorial.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String accountHolder;

    @ColumnDefault(value = "0.0")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany
    @JsonIgnore
    private Set<TransactionHistory> transactionHistories;

    @OneToMany
    @JsonIgnore
    private Set<Card> card;
}
