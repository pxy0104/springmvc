package com.pxy.controller;

import com.pxy.bean.Employee;
import com.pxy.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 2023/5/30
 **/
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        System.out.println("查询员工信息");
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id) {
        System.out.println("根据id删除员工");
        employeeDao.delete(id);
        return "redirect:/employee";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee) {
        System.out.println("添加员工");
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //update employee show again
    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable("id") Integer id, Model model) {
        System.out.println("回显员工信息");
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        System.out.println("保存员工信息");
        employeeDao.save(employee);
        return "redirect:/employee";
    }
}
