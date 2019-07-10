package com.springdata.jdbc.controller;

import com.springdata.jdbc.bean.Department;
import com.springdata.jdbc.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;
    
    @GetMapping(value = "/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return departmentMapper.getDepartment(id);
    }

    @GetMapping(value = "/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @PostMapping(value = "/dept/{id}")
    public Department update(@PathVariable("id")Integer id){
        Department department = departmentMapper.getDepartment(id);
        departmentMapper.updateDept(department);
        return department;
    }

    @DeleteMapping(value = "/dept/{id}")
    public void delete(@PathVariable("id") Integer id){
        departmentMapper.delById(id);
    }
}
