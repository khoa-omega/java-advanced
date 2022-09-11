package com.vti.repository;

import java.util.List;

public interface IDepartmentRepository {
    List<String> getAllDepartments();

    void createDepartment();
}
