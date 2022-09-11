package com.vti;

import com.vti.controller.DepartmentController;

//  SOLID Principles
//  D: Dependency inversion principle
//  - Module cấp cao không nên phụ thuộc trực tiếp vào một triển khai cụ thể của module cấp dưới
//  => Nên phụ thuộc vào interface / abstract
public class Program {
    public static void main(String[] args) {
        DepartmentController controller = new DepartmentController();
        controller.create();
        controller.getAll();
    }
}
