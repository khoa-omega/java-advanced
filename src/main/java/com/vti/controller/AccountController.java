package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public List<AccountDTO> findAll() {
        List<Account> accounts = service.findAll();
        return mapper.map(accounts, new TypeToken<List<AccountDTO>>() {
        }.getType());
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable("id") int id) {
        Account account = service.findById(id);
        return mapper.map(account, AccountDTO.class);
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
