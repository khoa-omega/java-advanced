package com.vti.service;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(int id);

    void save(Account account);

    void deleteById(int id);

    boolean existsById(int id);
}
