package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.LoginDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.MultipleEntries;
import com.bridgelabz.employeepayrollapp.exception.UserNotFound;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface IEmployeePayrollService {
    String login(LoginDTO loginDTO);

    String welcomeMessageForEmployee(Employee employee);
    String welcomeMessage();
    Employee addEmployeeMessage(EmployeeDTO employee) throws MultipleEntries;
    Employee editEmployeeMessage(String id,EmployeeDTO employee) throws UserNotFound;

    String deleteEmployeeMessage(String id);

    List<Employee> getAllEmployeeMessage();

    Employee getEmployeeByIDMessage(String id) throws UserNotFound;
    List<Employee> getEmployeeByDepartment(String department);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeeByGender(String gender);
    List<Employee> getEmployeeBySalary(long min_salary,long max_salary);
    List<Employee> getEmployeeByStartDate(Date start_Date, Date end_Date);
    List<Employee> getEmployeeByExactStartDate(Date start_Date);
}
