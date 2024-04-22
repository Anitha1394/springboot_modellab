package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Account;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Long id);
    Account getAccountByAccountNumber(String accountNumber);
    List<Account> getAccountsByAccountHolderName(String accountHolderName);
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccountById(Long id);
}