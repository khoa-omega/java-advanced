package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
//    @Query(value = "SELECT * FROM department WHERE name LIKE %:search%", nativeQuery = true)
//    @Query("FROM Department WHERE name LIKE %?1%")
    @Query("FROM Department WHERE name LIKE %:search%")
    List<Department> searchByName(@Param("search") String search);

    @Query("DELETE FROM Department WHERE name = :name")
    @Modifying
    void deleteByName(@Param("name") String name);

    Department findByName(String name);

    List<Department> findByTotalMembersGreaterThanEqual(int min);

    List<Department> findByNameAndTotalMembersGreaterThanEqual(String name, int min);
}
