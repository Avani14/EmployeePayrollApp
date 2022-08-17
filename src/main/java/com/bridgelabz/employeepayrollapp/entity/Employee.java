package com.bridgelabz.employeepayrollapp.entity;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Employee")
@Data
@ToString
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long salary;

    private String email;

    private String password;
    private String gender;
    private Date start_date;
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
    private List<String> department;

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.department = employeeDTO.getDepartment();
        this.start_date = employeeDTO.getStart_date();
        this.email = employeeDTO.getEmail();
        this.password = employeeDTO.getPassword();
    }
}