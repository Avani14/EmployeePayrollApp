package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Please enter valid name")
    private String name;
    @Pattern(regexp = "male|female|other",message = "Please enter valid gender")
    private String gender;
    @Min(50)
    private long salary;
    @NotNull
    private List<String> department;
}
