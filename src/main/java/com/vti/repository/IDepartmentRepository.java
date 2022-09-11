package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("FROM Department AS d WHERE d.name LIKE %:search%")
    Page<Department> searchByName(@Param("search") String search, Pageable pageable);

    void deleteByName(String name);

    Department findByName(String name);

    List<Department> findByTotalMembersGreaterThanEqual(int min);

    List<Department> findByNameAndTotalMembersGreaterThanEqual(String name, int min);
}
