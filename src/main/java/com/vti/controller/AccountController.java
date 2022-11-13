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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private IAccountService service;

    @GetMapping
    public Page<AccountDTO> findAll(Pageable pageable, AccountFilterForm form) {
        Page<Account> page = service.findAll(pageable, form);
        List<Account> accounts = page.getContent();
        List<AccountDTO> dtos = mapper.map(accounts, new TypeToken<List<AccountDTO>>() {}.getType());
        for (AccountDTO dto : dtos) {
            dto.add(linkTo(methodOn(AccountController.class).findById(dto.getId())).withSelfRel());
        }
        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable("id") Integer id) {
        Account account = service.findById(id);
        AccountDTO dto = mapper.map(account, AccountDTO.class);
        return dto.add(linkTo(methodOn(AccountController.class).findById(id)).withSelfRel());
    }

    @PostMapping
    public void create(@RequestBody AccountCreateForm form) {
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody AccountUpdateForm form) {
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody List<Integer> ids) {
        service.deleteAllById(ids);
    }
}
