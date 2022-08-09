package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    String welcomeMessageForEmployee(Employee employee);
    String welcomeMessage();
    String addEmployeeMessage(Employee employee);
    String editEmployeeMessage(long id,Employee employee);

    String deleteEmployeeMessage(long id);

    List<Employee> getAllEmployeeMessage();

    Employee getAllEmployeeByIDMessage(long id);
}
