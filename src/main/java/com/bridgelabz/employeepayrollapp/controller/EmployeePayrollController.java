package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employeepayroll")
public class EmployeePayrollController {
    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping("/welcome")
    public String welcomeEmployee(){
        return employeePayrollService.welcomeMessage();
    }

}
