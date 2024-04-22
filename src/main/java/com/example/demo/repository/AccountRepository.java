package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Account;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Custom method to find accounts by account holder name
    List<Account> findByAccountHolderName(String accountHolderName);
    
    // Custom method to find accounts by account number
    Account findByAccountNumber(String accountNumber);
    
    // Add more custom methods as needed
}