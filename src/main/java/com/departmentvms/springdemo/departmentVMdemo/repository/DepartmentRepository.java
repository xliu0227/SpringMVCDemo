package com.departmentvms.springdemo.departmentVMdemo.repository;

import com.departmentvms.springdemo.departmentVMdemo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("from Department where name = ?1")
    List<Department> findByName(String name);
}
