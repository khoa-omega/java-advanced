package com.vti.controller;

import com.vti.service.DepartmentService;

import java.util.List;

public class DepartmentController {

    private DepartmentService service;

    public DepartmentController() {
        service = new DepartmentService();
    }

    public void getAllDepartments() {
        List<String> departments = service.processDepartments();
        printDepartmentReport(departments);
    }

    public void printDepartmentReport(List<String> departments) {
        // TODO ...
    }
}
