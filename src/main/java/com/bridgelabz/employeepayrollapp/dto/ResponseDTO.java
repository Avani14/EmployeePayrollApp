package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {
    private String message;
    private Employee employeeList;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

}
