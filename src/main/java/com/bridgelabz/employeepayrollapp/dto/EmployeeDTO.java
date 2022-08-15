package com.bridgelabz.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.List;

@Data
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}",message = "Please enter valid name")
    private String name;
    @Min(50)
    private long salary;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @Pattern(regexp = "male|female|other",message = "Please enter valid gender")
    private String gender;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date start_date;
    @NotNull
    private List<String> department;
}
