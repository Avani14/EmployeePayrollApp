package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.Employee;
import com.bridgelabz.employeepayrollapp.exception.UserNotFound;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{
    HashMap<Long,Employee> employeePayrollRecord = new HashMap<Long,Employee>();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public String welcomeMessage() {
        return "Welcome";
    }

    @Override
    public Employee addEmployeeMessage(EmployeeDTO employeeDTO) {
        employeeDTO.setPassword(bCryptPasswordEncoder.encode(employeeDTO.getPassword()));
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployeeMessage(long id,EmployeeDTO employeeDTO) throws UserNotFound {
        Employee employee = new Employee(employeeDTO);
        Optional<Employee> employee1 = Optional.ofNullable(employeeRepository.findById(id).orElse(null));
        if(employee1 == null){
            throw new UserNotFound("Employee with id "+id+" does not exists, please try again");
        }
        employee1.get().setName(employee.getName());
        employee1.get().setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
        employee1.get().setEmail(employee.getEmail());
        employee1.get().setGender(employee.getGender());
        employee1.get().setSalary(employee.getSalary());
        employee1.get().setDepartment(employee.getDepartment());
        employee1.get().setStart_date(employee.getStart_date());
        return employeeRepository.save(employee1.get());
    }

    @Override
    public String deleteEmployeeMessage(long id) {
        employeeRepository.deleteById(id);
        return "The employee with id: "+ id+" is deleted successfully";
    }

    @Override
    public List<Employee> getAllEmployeeMessage() {
//        System.out.println("All Employee's details are :\n ");
//        List<Employee> employeeList = employeePayrollRecord.entrySet().stream().map(employee->employee.getValue()).toList();
        return employeeRepository.findAll();
    }


    @Override
    public Employee getEmployeeByIDMessage(long id) throws UserNotFound {
//        Employee employee = employeePayrollRecord.get(id);
        Employee employee =  employeeRepository.findById(id).orElse(null);
        if(employee == null){
            throw new UserNotFound("Employee of id: "+id+" not found");
        }
        else{
            return employee;
        }
    }

    @Override
    public List<Employee> getEmployeeByDepartment(String department) {
        return employeeRepository.getEmployeeByDepartment(department);
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        return employeeRepository.getEmployeeByGender(gender);
    }

    @Override
    public List<Employee> getEmployeeBySalary(long min_salary, long max_salary) {
        return employeeRepository.getEmployeeBySalary(min_salary,max_salary);
    }

    @Override
    public List<Employee> getEmployeeByStartDate(Date start_Date, Date end_Date) {
        return employeeRepository.getEmployeeByStart_date(start_Date,end_Date);
    }

    @Override
    public List<Employee> getEmployeeByExactStartDate(Date start_Date) {
        return employeeRepository.getEmployeeByExactStart_date(start_Date);
    }

    @Override
    public Employee login(String email, String password) {
        return employeeRepository.getEmployeeByEmail(email,password);
    }

    @Override
    public String welcomeMessageForEmployee(Employee employee) {
        employeePayrollRecord.put(employee.getId(),employee);
        System.out.println(employeePayrollRecord);
        return "Welcome "+employee.getName();
    }

}
