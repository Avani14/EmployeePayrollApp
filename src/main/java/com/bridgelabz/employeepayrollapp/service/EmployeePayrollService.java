package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{

    @Override
    public String welcomeMessage() {
        return "Welcome Employee";
    }
}
