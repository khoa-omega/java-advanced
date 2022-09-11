package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> searchByName(String search);

    @Modifying
    void deleteByName(String name);

    Department findByName(String name);

    List<Department> findByTotalMembersGreaterThanEqual(int min);

    List<Department> findByNameAndTotalMembersGreaterThanEqual(String name, int min);
}
