package com.departmentvms.springdemo.departmentVMdemo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;

//@ApiModel(description="All details about the Department")
@Entity
public class Department {
    @Id
    @GeneratedValue
    private int id;

    @Size(min=2, message="Name should have at least two characters")
    private String name;

    @OneToMany(mappedBy = "department")
    private List<VM> vms;

    protected Department(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VM> getVms() {
        return vms;
    }

    public void setVms(List<VM> vms) {
        this.vms = vms;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
