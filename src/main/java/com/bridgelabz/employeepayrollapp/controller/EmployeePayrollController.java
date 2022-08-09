package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @GetMapping("/welcome")
    public String welcome(){
        return employeePayrollService.welcomeMessage();
    }
    @GetMapping("/welcome/employee")
    public String welcomeEmployee(@RequestBody Employee employee){
        return employeePayrollService.welcomeMessageForEmployee(employee);
    }
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return employeePayrollService.addEmployeeMessage(employee);
    }
    @PutMapping("/editEmployee/{id}")
    public String editEmployee(@RequestBody Employee employee,@PathVariable long id){
        return employeePayrollService.editEmployeeMessage(id,employee);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id){
        return employeePayrollService.deleteEmployeeMessage(id);
    }
    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee(){
        return employeePayrollService.getAllEmployeeMessage();
    }
    @GetMapping("/getEmployeeById/{id}")
    public Employee getAllEmployeeByID(@PathVariable long id){
        return employeePayrollService.getAllEmployeeByIDMessage(id);
    }
}
