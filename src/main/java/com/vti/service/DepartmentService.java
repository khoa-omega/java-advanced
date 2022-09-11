package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Department findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Department findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Page<Department> searchByName(String search, Pageable pageable) {
        return repository.searchByName(search, pageable);
    }

    @Override
    public void save(Department department) {
        repository.save(department);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }
}
