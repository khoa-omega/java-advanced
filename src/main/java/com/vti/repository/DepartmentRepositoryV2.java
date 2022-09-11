package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DepartmentRepositoryV2")
public class DepartmentRepositoryV2 implements IDepartmentRepository {
    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public Department getByName(String name) {
        return null;
    }

    @Override
    public void create(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
