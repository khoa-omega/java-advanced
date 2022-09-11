package com.vti;

//  SOLID Principles
//  S: Single responsibility
//  - Mỗi class chỉ nên có một mục đích (trách nhiệm)
//  => Chỉ có một lý do để thay đổi
//  => Dễ dàng quản lý, mở rộng, bảo trì (maintain)
public class Program {
    public static void main(String[] args) {
        Department department = new Department();
        department.showAll();
    }
}
