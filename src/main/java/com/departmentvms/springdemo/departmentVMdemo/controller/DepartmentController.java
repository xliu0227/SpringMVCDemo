package com.departmentvms.springdemo.departmentVMdemo.controller;

import com.departmentvms.springdemo.departmentVMdemo.Entity.Department;
import com.departmentvms.springdemo.departmentVMdemo.Entity.VM;
import com.departmentvms.springdemo.departmentVMdemo.Exception.NotFoundException;
import com.departmentvms.springdemo.departmentVMdemo.services.DepartmentService;
import com.departmentvms.springdemo.departmentVMdemo.services.VMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService deptServ;
    @Autowired
    private VMService vmServ;
    @GetMapping("/departments")
    public List<Department> retrieveAllDeps(){
        return deptServ.getAllDepartment();
    }
    @GetMapping("/departments/{id}")
    public Department retrieveDeptById(@PathVariable int id){
        return deptServ.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public ResponseEntity<Object> createDepartment(@Valid @RequestBody Department dept){
        Department savedDepartment = deptServ.addDepartment(dept);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedDepartment.getId())
                .toUri();

        return  ResponseEntity.created(location).build();
    }

    @GetMapping("/departmentsByName/{name}")
    public List<Department> retrieveByName(@PathVariable String name){
        List<Department> getDepts = deptServ.findDepartmentByName(name);
        if(getDepts.size() == 0){
            throw new NotFoundException("No Department with the name " + name + "was found");
        }

        return getDepts;
    }

    @GetMapping("/departments/{deptId}/vms")
    public List<VM> retrieveAllVMByDepartment(@PathVariable int deptId){
        Department getDept = this.retrieveDeptById(deptId);
        return getDept.getVms();
    }

    @GetMapping("/departments/{deptId}/vms/{os}")
    public List<VM> retrieveAllVMByDepartmentByOS(@PathVariable int deptId, @PathVariable String os){
        Department getDept = this.retrieveDeptById(deptId);
        List<VM> getVMs = getDept.getVms();
        List<VM> result = new ArrayList<>();
        for(int i = 0; i < getVMs.size(); i ++){
            if(getVMs.get(i).getOS().equals(os.toLowerCase())){
                result.add(getVMs.get(i));
            }
        }

        if(result.size() == 0){
            throw new NotFoundException("No VM has " + os + " OS under department " + getDept.getName());
        }
        return result;
    }

    @PostMapping("/departments/{id}/vms")
    public ResponseEntity<Object> createVM(@PathVariable int id, @RequestBody VM vm){
        Department getDept = deptServ.getDepartmentById(id);
        vm.setDepartment(getDept);
        vmServ.addVM(vm);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(getDept.getId())
                .toUri();

        return  ResponseEntity.created(location).build();
    }
}
