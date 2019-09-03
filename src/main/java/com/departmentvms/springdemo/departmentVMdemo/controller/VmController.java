package com.departmentvms.springdemo.departmentVMdemo.controller;

import com.departmentvms.springdemo.departmentVMdemo.Entity.VM;
import com.departmentvms.springdemo.departmentVMdemo.Exception.NotFoundException;
import com.departmentvms.springdemo.departmentVMdemo.services.VMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class VmController {
    //get all vms
    //get by id
    //get by system
    //get by department

    @Autowired
    private VMService vmService;

    @GetMapping("/vms")
    public List<VM> retrieveAllVMs(){
        return vmService.getAllVM();
    }

    @GetMapping("/vms/{id}")
    public VM retrieveVMById(@PathVariable int id){
        return vmService.getVMById(id);
    }

    @GetMapping("/vmsbyos/{os}")
    public List<VM> findVMbyOS(@PathVariable String os){
        List<VM> getVMs = vmService.findVMByOS(os);
        if(getVMs.size() == 0){
            throw new NotFoundException("No VM with the OS name " + os + " was found");
        }

        return getVMs;
    }
}
