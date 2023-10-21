package com.example.tutorial.service;

import com.example.tutorial.dto.TransactionHistoryDto;
import com.example.tutorial.entity.Account;
import com.example.tutorial.entity.TransactionHistory;
import com.example.tutorial.repository.AccountRepository;
import com.example.tutorial.repository.TransactionHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionHistoryService {

    private final TransactionHistoryRepository transactionHistoryRepository;
    private final AccountRepository accountRepository;

    public TransactionHistoryService(TransactionHistoryRepository transactionHistoryRepository, AccountRepository accountRepository) {
        this.transactionHistoryRepository = transactionHistoryRepository;
        this.accountRepository = accountRepository;
    }

    public List<TransactionHistory> getTransactionHistories() {
        return this.transactionHistoryRepository.findAll();
    }

    public TransactionHistory getTransactionHistory(UUID id) {
        return this.transactionHistoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public TransactionHistory createTransactionHistory(TransactionHistoryDto transactionHistoryDto) throws Exception {
        Account source = this.accountRepository.findById(transactionHistoryDto.getSourceId()).orElseThrow();
        Account destination = this.accountRepository.findById(transactionHistoryDto.getDestinationId()).orElseThrow();

        if (source.getBalance().subtract(transactionHistoryDto.getAmount()).compareTo(BigDecimal.valueOf(0)) < 0) {
            throw new Exception("Not enough money");
        }

        source.setBalance(source.getBalance().subtract(transactionHistoryDto.getAmount()));
        destination.setBalance(destination.getBalance().add(transactionHistoryDto.getAmount()));

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAmount(transactionHistoryDto.getAmount());

        transactionHistory.setSource(source);
        transactionHistory.setDestination(destination);

        return this.transactionHistoryRepository.save(transactionHistory);
    }
}
