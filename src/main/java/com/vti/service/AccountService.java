package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Account account) {
        repository.save(account);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
