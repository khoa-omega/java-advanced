package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @GetMapping
    public List<AccountDTO> findAll() {
        List<Account> accounts = service.findAll();
        List<AccountDTO> accountDTOs = new ArrayList<>();
        for (Account account : accounts) {
            AccountDTO accountDTO = new AccountDTO(account.getUsername(), account.getDepartment().getName());
            accountDTOs.add(accountDTO);
        }
        return accountDTOs;
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable("id") int id) {
        Account account = service.findById(id);
        return new AccountDTO(account.getUsername(), account.getDepartment().getName());
    }

    @PostMapping
    public void create(@RequestBody AccountCreateForm form) {
        service.save(form.toEntity());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody AccountUpdateForm form) {
        service.save(form.toEntity(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
}
