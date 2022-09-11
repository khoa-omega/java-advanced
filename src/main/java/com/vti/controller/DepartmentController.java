package com.vti.controller;

import com.vti.service.IDepartmentService;

import java.util.List;

public class DepartmentController {
    private IDepartmentService service;

    public DepartmentController(IDepartmentService service) {
        this.service = service;
    }

    public void getAllDepartments() {
        List<String> departments = service.processDepartments();
        printDepartmentReport(departments);
    }

    public void printDepartmentReport(List<String> departments) {
        // TODO ...
    }
}
