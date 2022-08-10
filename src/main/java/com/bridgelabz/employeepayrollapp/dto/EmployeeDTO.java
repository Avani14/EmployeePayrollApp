package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "[A-Z]{1}[a-zA-Z]\\s]{2}",message = "Please enter valid name")
    private String name;
    @Pattern(regexp = "male|female|other",message = "Please enter valid gender")
    private String gender;
    private long salary;
}
