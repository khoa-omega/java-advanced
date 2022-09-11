package com.vti.service;

import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;

import java.util.List;

public class DepartmentService {

    private DepartmentRepository departmentRepository;
    private AccountRepository accountRepository;

    public DepartmentService() {
        departmentRepository = new DepartmentRepository();
        accountRepository = new AccountRepository();
    }

    public List<String> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    public List<String> processDepartments() {
        List<String> departments = getAllDepartments();
        // processing...
        return departments;
    }
}
