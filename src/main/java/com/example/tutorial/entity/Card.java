package com.example.tutorial.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String cardNumber;

    private int expiryMonth;

    private int expiryYear;

    private int cvv;

    @ManyToOne
    private Account account;
}
