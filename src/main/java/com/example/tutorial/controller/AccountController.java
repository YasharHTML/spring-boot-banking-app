package com.example.tutorial.controller;

import com.example.tutorial.dto.AccountDto;
import com.example.tutorial.entity.Account;
import com.example.tutorial.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<Account> getAccounts() {
        return this.accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable UUID id) {
        return this.accountService.getAccount(id);
    }

    @PostMapping()
    public Account createAccount(@RequestBody AccountDto accountDto) {
        return this.accountService.createAccount(accountDto);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable UUID id, @RequestBody AccountDto accountDto) {
        return this.accountService.updateAccount(id, accountDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable UUID id) {
        this.accountService.deleteAccount(id);
    }
}
