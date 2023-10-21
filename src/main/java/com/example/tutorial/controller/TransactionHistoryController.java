package com.example.tutorial.controller;

import com.example.tutorial.dto.TransactionHistoryDto;
import com.example.tutorial.entity.TransactionHistory;
import com.example.tutorial.service.TransactionHistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionHistoryController {

    private final TransactionHistoryService transactionHistoryService;

    public TransactionHistoryController(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @GetMapping
    public List<TransactionHistory> getTransactionHistories() {
        return this.transactionHistoryService.getTransactionHistories();
    }

    @GetMapping("/{id}")
    public TransactionHistory getTransactionHistory(@PathVariable UUID id) {
        return this.transactionHistoryService.getTransactionHistory(id);
    }

    @PostMapping
    public TransactionHistory createTransactionHistory(@RequestBody TransactionHistoryDto transactionHistoryDto) throws Exception {
        return this.transactionHistoryService.createTransactionHistory(transactionHistoryDto);
    }
}
