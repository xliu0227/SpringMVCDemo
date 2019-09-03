package com.departmentvms.springdemo.departmentVMdemo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class VM {
    @Id
    @GeneratedValue
    private int id;
    private String OS;
    private Date createdDate;

    protected VM(){}

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore
    private Department department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "VM{" +
                "id=" + id +
                ", OS='" + OS + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public VM(int id, String OS, Date createdDate) {
        this.id = id;
        this.OS = OS;
        this.createdDate = createdDate;
    }
}
