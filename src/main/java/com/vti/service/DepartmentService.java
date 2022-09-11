package com.vti.service;

import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;

import java.util.List;

public class DepartmentService implements IDepartmentService {
    private IDepartmentRepository departmentRepository;
    private IAccountRepository accountRepository;

    public DepartmentService(IDepartmentRepository departmentRepository, IAccountRepository accountRepository) {
        this.departmentRepository = departmentRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<String> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public List<String> processDepartments() {
        List<String> departments = getAllDepartments();
        // processing...
        return departments;
    }
}
