package com.departmentvms.springdemo.departmentVMdemo.services;

import com.departmentvms.springdemo.departmentVMdemo.Exception.NotFoundException;
import com.departmentvms.springdemo.departmentVMdemo.repository.DepartmentRepository;
import com.departmentvms.springdemo.departmentVMdemo.Entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id){
        Optional<Department> dept =  departmentRepository.findById(id);

        if(!dept.isPresent()){
            throw new NotFoundException("There is not department having an id as " + id);
        }

        return  dept.get();
    }

    public Department addDepartment(Department dept){
        Department savedDepartment = departmentRepository.save(dept);
        return savedDepartment;
    }

    public List<Department> findDepartmentByName(String pattern){
        List<Department> depts = departmentRepository.findByName(pattern);
        return depts;
    }
}
