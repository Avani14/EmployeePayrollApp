package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
//        Employee employee = modelMapper.map(employeeDTO,Employee.class);
        Employee emp = employeePayrollService.addEmployeeMessage(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Employee added successfully!",emp);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/editEmployee/{id}")
    public ResponseEntity<ResponseDTO> editEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable long id){
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
    public List<EmployeeDTO> getAllEmployee(){
        return employeePayrollService.getAllEmployeeMessage().stream().map(emp->modelMapper.map(emp,EmployeeDTO.class)).collect(Collectors.toList());
    }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<EmployeeDTO> getAllEmployeeByID(@PathVariable long id){
        Employee employee = employeePayrollService.getEmployeeByIDMessage(id);
        EmployeeDTO employeeDTO = modelMapper.map(employee,EmployeeDTO.class);
        return ResponseEntity.ok().body(employeeDTO);
    }
}
