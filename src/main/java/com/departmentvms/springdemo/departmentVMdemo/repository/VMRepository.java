package com.departmentvms.springdemo.departmentVMdemo.repository;

import com.departmentvms.springdemo.departmentVMdemo.Entity.VM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VMRepository extends JpaRepository<VM, Integer> {
    @Query("from VM where os = ?1")
    List<VM> findByOS(String vm);
}
