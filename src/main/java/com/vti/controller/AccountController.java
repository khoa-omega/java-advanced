package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountFilterForm;
import com.vti.form.AccountUpdateForm;
import com.vti.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<AccountDTO> findAll(Pageable pageable, AccountFilterForm form) {
        Page<Account> accounts = service.findAll(pageable, form);
        List<AccountDTO> accountDTOs = mapper.map(
                accounts.getContent(),
                new TypeToken<List<AccountDTO>>() {}.getType()
        );
        return new PageImpl<>(accountDTOs, pageable, accounts.getTotalElements());
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
