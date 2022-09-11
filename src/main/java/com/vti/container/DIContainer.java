package com.vti.container;

import com.vti.controller.DepartmentController;
import com.vti.repository.AccountRepository;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.service.DepartmentService;
import com.vti.service.IDepartmentService;

public class DIContainer {
    public IDepartmentRepository initDepartmentRepository() {
        return new DepartmentRepository();
    }

    public IAccountRepository initAccountRepository() {
        return new AccountRepository();
    }

    public IDepartmentService initDepartmentService() {
        IDepartmentRepository departmentRepository = initDepartmentRepository();
        IAccountRepository accountRepository = initAccountRepository();

        return new DepartmentService(departmentRepository, accountRepository);
    }

    public DepartmentController initController() {
        IDepartmentService departmentService = initDepartmentService();

        return new DepartmentController(departmentService);
    }
}
