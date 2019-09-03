package com.departmentvms.springdemo.departmentVMdemo.services;

import com.departmentvms.springdemo.departmentVMdemo.Exception.NotFoundException;
import com.departmentvms.springdemo.departmentVMdemo.repository.VMRepository;
import com.departmentvms.springdemo.departmentVMdemo.Entity.VM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VMService {
    @Autowired
    private VMRepository vmRepo;

    public List<VM> getAllVM(){
        return vmRepo.findAll();
    }

    public VM getVMById(int id){
        Optional<VM> getVM =  vmRepo.findById(id);

        if(!getVM.isPresent()){
            throw new NotFoundException("There is not VM having an id as " + id);
        }

        return  getVM.get();
    }

    public VM addVM(VM vm){
        VM savedVM = vmRepo.save(vm);
        return savedVM;
    }

    public List<VM> findVMByOS(String pattern){
        return vmRepo.findByOS(pattern);
    }
}
