package com.example.tutorial.service;

import com.example.tutorial.dto.AccountDto;
import com.example.tutorial.entity.Account;
import com.example.tutorial.mapper.AccountMapper;
import com.example.tutorial.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<Account> getAccounts() {
        return this.accountRepository.findAll();
    }

    public Account getAccount(UUID id) {
        return this.accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(AccountDto accountDto) {
        Account account = new Account();
        accountMapper.updateAccountFromDto(accountDto, account);
        return this.accountRepository.save(account);
    }

    public Account updateAccount(UUID id, AccountDto accountDto) {
        Account account = this.accountRepository.findById(id).orElseThrow();
        accountMapper.updateAccountFromDto(accountDto, account);
        return this.accountRepository.save(account);
    }

    public void deleteAccount(UUID id) {
        this.accountRepository.deleteById(id);
    }
}
