package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    HashMap<Long,Employee> employeePayrollRecord = new HashMap<Long,Employee>();

    @Override
    public String welcomeMessage() {
        return "Welcome";
    }

    @Override
    public String addEmployeeMessage(Employee employee) {
        employeePayrollRecord.put(employee.getId(),employee);
        System.out.println(employeePayrollRecord);
        return "Employee Name: "+employee.getName()+" ID: "+employee.getId()+" added successfully";
    }

    @Override
    public String editEmployeeMessage(long id,Employee employee) {
        Employee employee1 = employeePayrollRecord.get(id);
        employee1.updateEmployee(employee);
        System.out.println(employeePayrollRecord);
        return "The employee with id: "+ id+" is updated successfully";
    }

    @Override
    public String deleteEmployeeMessage(long id) {
        employeePayrollRecord.remove(id);
        System.out.println(employeePayrollRecord);
        return "The employee with id: "+ id+" is deleted successfully";
    }

    @Override
    public List<Employee> getAllEmployeeMessage() {
        System.out.println("All Employee's details are :\n ");
        List<Employee> employeeList = employeePayrollRecord.entrySet().stream().map(employee->employee.getValue()).toList();
        return employeeList;
    }

    @Override
    public Employee getAllEmployeeByIDMessage(long id) {
        Employee employee = employeePayrollRecord.get(id);
        return employee;
    }

    @Override
    public String welcomeMessageForEmployee(Employee employee) {
        employeePayrollRecord.put(employee.getId(),employee);
        System.out.println(employeePayrollRecord);
        return "Welcome "+employee.getName();
    }

}
