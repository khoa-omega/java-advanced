package com.vti.controller;

import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @GetMapping
    public Page<Account> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable("id") int id) {
        return service.findById(id);
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
