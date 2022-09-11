package com.vti;

import com.vti.controller.DepartmentController;

public class Program {
    public static void main(String[] args) {
        DepartmentController departmentController = new DepartmentController();

        // using controller
        departmentController.getAllDepartments();
    }
}
