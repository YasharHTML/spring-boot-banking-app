package com.example.tutorial.dto;

import com.example.tutorial.enums.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDto {
    private String accountHolder;
    private BigDecimal balance;
    private AccountType accountType;
}
