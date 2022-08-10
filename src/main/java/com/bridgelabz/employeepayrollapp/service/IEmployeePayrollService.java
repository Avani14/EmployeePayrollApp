package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    String welcomeMessageForEmployee(Employee employee);
    String welcomeMessage();
    Employee addEmployeeMessage(Employee employee);
    Employee editEmployeeMessage(long id,Employee employee);

    String deleteEmployeeMessage(long id);

    List<Employee> getAllEmployeeMessage();

    Employee getEmployeeByIDMessage(long id);
}
