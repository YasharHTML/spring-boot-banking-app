package com.example.tutorial.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TransactionHistoryDto {
    private BigDecimal amount;
    private UUID sourceId;
    private UUID destinationId;
}
