package com.vti;

import com.vti.repository.DepartmentRepositoryV1;

//  SOLID Principles
//  O: open/closed principle
//  - Các class nên nói "CÓ" với mở rộng chức năng và nói "KHÔNG" với chỉnh sửa code
//  => Có thể thêm được tính năng mới mà không cần phải chỉnh sửa code hiện tại
//  - Có 2 cách:
//      + Is-a: Sử dụng kế thừa (inheritance)
//      + Has-a: Sử dụng thuộc tính (property)
public class Program {
    public static void main(String[] args) {
        DepartmentRepositoryV1 repository = new DepartmentRepositoryV1();
        repository.create();
        repository.getAll();
    }
}
