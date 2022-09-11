package com.vti;

import com.vti.container.DIContainer;
import com.vti.controller.DepartmentController;
import com.vti.service.IDepartmentService;

public class Program {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();

        // get controller bean
        DepartmentController departmentController = container.initController();
        departmentController.getAllDepartments();

        // get service bean
        IDepartmentService departmentService = container.initDepartmentService();

        // ...
    }
}
