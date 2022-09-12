package com.vti.service;

import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    Page<Account> findAll(Pageable pageable, String search);

    Account findById(int id);

    void save(Account account);

    void deleteById(int id);

    boolean existsById(int id);
}
