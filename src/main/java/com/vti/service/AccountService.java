package com.vti.service;

import com.vti.entity.Account;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountFilterForm;
import com.vti.form.AccountUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Account> findAll(Pageable pageable, AccountFilterForm form) {
        return repository.findAll(AccountSpecification.buildWhere(form), pageable);
    }

    @Override
    public Account findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(AccountCreateForm form) {
        TypeMap<AccountCreateForm, Account> typeMap = mapper.getTypeMap(AccountCreateForm.class, Account.class);
        if (typeMap == null) {
            mapper.addMappings(new PropertyMap<AccountCreateForm, Account>() {
                @Override
                protected void configure() {
                    skip(destination.getId());
                }
            });
        }
        repository.save(mapper.map(form, Account.class));
    }

    @Override
    public void update(AccountUpdateForm form) {
        repository.save(mapper.map(form, Account.class));
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(
                account.getUsername(),
                account.getPassword(),
                Collections.emptyList()
        );
    }

    @Override
    public Account findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
