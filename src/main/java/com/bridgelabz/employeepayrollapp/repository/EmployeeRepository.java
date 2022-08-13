package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and department = :department",nativeQuery = true)
    public List<Employee> getEmployeeByDepartment(String department);
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and name = :name",nativeQuery = true)
    public List<Employee> getEmployeeByName(String name);
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and employee.salary between :min_salary and :max_salary",nativeQuery = true)
    public List<Employee> getEmployeeBySalary(long min_salary,long max_salary);
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and employee.start_date between :start_Date and :end_Date",nativeQuery = true)
    public List<Employee> getEmployeeByStart_date(Date start_Date, Date end_Date);
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and gender = :gender",nativeQuery = true)
    public List<Employee> getEmployeeByGender(String gender);
    @Query(value = "select * from employee,employee_department where employee.id = employee_department.id and employee.start_date = :start_Date",nativeQuery = true)
    public List<Employee> getEmployeeByExactStart_date(Date start_Date);
}
