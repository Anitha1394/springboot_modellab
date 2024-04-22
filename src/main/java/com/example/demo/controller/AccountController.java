package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public String listAccounts(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "accounts";
    }

    @GetMapping("/accounts/new")
    public String createAccountForm(Model model) {
        model.addAttribute("account", new Account());
        return "create_account";
    }

    @PostMapping("/accounts")
    public String saveAccount(@ModelAttribute("account") Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/edit/{id}")
    public String editAccountForm(@PathVariable(name = "id") Long id, Model model) {
        Account account = accountService.getAccountById(id);
        model.addAttribute("account", account);
        return "edit_account";
    }

    @PostMapping("/accounts/update/{id}")
    public String updateAccount(@PathVariable(name = "id") Long id, @ModelAttribute("account") Account account) {
        account.setId(id); // Ensure the ID is set
        accountService.updateAccount(account);
        return "redirect:/accounts";
    }

    @GetMapping("/accounts/delete/{id}")
    public String deleteAccount(@PathVariable(name = "id") Long id) {
        accountService.deleteAccountById(id);
        return "redirect:/accounts";
    }
}