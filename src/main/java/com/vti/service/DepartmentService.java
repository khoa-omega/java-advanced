package com.vti.service;

import com.vti.repository.DepartmentRepository;

public class DepartmentService {
    private final DepartmentRepository repository = new DepartmentRepository();

    public void create() {
        repository.create();
    }

    public void getAll() {
        repository.getAll();
    }
}
