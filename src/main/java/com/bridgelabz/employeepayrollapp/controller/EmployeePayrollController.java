package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.UserNotFound;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/employeepayroll")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;
    @Autowired
    ModelMapper modelMapper;
    @GetMapping("/welcome")
    public String welcome(){
        return employeePayrollService.welcomeMessage();
    }
    @GetMapping("/welcome/employee")
    public String welcomeEmployee(@RequestBody Employee employee){
        return employeePayrollService.welcomeMessageForEmployee(employee);
    }
    @ApiOperation(value = "Add the Employee",notes = "This api will add the employee to the database if the entries are valid")
    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
//        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee emp = employeePayrollService.addEmployeeMessage(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee added successfully!",emp);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/editEmployee/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable long id) throws UserNotFound{
//        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee emp = employeePayrollService.editEmployeeMessage(id,employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee edited successfully!",emp);
        return ResponseEntity.ok().body(responseDTO);
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id){
         return  employeePayrollService.deleteEmployeeMessage(id);
    }
    @GetMapping("/getEmployee")
    public ResponseEntity<ResponseDTO> getAllEmployee(){
        List<Employee> employeeList = employeePayrollService.getAllEmployeeMessage();
        ResponseDTO responseDTO;
        if(employeeList.stream().count() ==0){
            responseDTO = new ResponseDTO("No employee available in database",employeeList);
        }
        responseDTO = new ResponseDTO("Employee present in database are :",employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<ResponseDTO> getAllEmployeeByID(@PathVariable long id) throws UserNotFound {
        Employee employee = employeePayrollService.getEmployeeByIDMessage(id);
        ResponseDTO responseDTO = new ResponseDTO("The Employee is:",employee);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeByDepartment/{department}")
    public ResponseEntity<ResponseDTO> getEmployeeByDepartment(@PathVariable String department) {
        List<Employee> employeeList = employeePayrollService.getEmployeeByDepartment(department);
        ResponseDTO responseDTO = new ResponseDTO("The Employee of department :"+department,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeByName/{name}")
    public ResponseEntity<ResponseDTO> getEmployeeByName(@PathVariable String name) {
        List<Employee> employeeList = employeePayrollService.getEmployeeByName(name);
        ResponseDTO responseDTO = new ResponseDTO("The Employee of name :"+name,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeBySalary")
    public ResponseEntity<ResponseDTO> getEmployeeBySalary(@RequestParam long min_salay,@RequestParam long max_salary) {
        List<Employee> employeeList = employeePayrollService.getEmployeeBySalary(min_salay,max_salary);
        ResponseDTO responseDTO = new ResponseDTO("The Employee having salary between :"+min_salay+" and "+max_salary,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeByStartDate")
    public ResponseEntity<ResponseDTO> getEmployeeByStart_date(@RequestParam Date start_Date, @RequestParam Date end_Date) {
        List<Employee> employeeList = employeePayrollService.getEmployeeByStartDate(start_Date,end_Date);
        ResponseDTO responseDTO = new ResponseDTO("The Employee having joined between :"+start_Date+" and "+end_Date,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeByGender")
    public ResponseEntity<ResponseDTO> getEmployeeByGender(@Valid @RequestParam String gender) {
        List<Employee> employeeList = employeePayrollService.getEmployeeByGender(gender);
        ResponseDTO responseDTO = new ResponseDTO("The Employees who are :"+gender,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
    @GetMapping("/getEmployeeByExactStart_date")
    public ResponseEntity<ResponseDTO> getEmployeeByExactStart_date(@RequestParam Date start_Date) {
        List<Employee> employeeList = employeePayrollService.getEmployeeByExactStartDate(start_Date);
        ResponseDTO responseDTO = new ResponseDTO("The Employees who are :"+start_Date,employeeList);
        return ResponseEntity.ok().body(responseDTO);
    }
}
