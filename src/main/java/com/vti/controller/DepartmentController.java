package com.vti.controller;

import com.vti.service.DepartmentService;

public class DepartmentController {
    private final DepartmentService service = new DepartmentService();

    public void create() {
        service.create();
    }

    public void getAll() {
        service.getAll();
    }
}
