package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return repository.findAll();
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
    public List<Department> searchByName(String search) {
        return repository.searchByName(search);
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
