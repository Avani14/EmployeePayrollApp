package com.bridgelabz.employeepayrollapp.advice;

import com.bridgelabz.employeepayrollapp.exception.MultipleEntries;
import com.bridgelabz.employeepayrollapp.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class EmployeePayrollAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> invalidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errorMapping = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error->{
            errorMapping.put(error.getField(),error.getDefaultMessage());
        });
        return errorMapping;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public Map<String, String> elementNotFound(NoSuchElementException noSuchElementException) {
        Map<String, String> errorMapping = new HashMap<>();
        errorMapping.put("error",noSuchElementException.getMessage());
        return errorMapping;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UserNotFound.class)
    public Map<String, String> userNotFount(UserNotFound userNotFound) {
        Map<String, String> errorMapping = new HashMap<>();
        errorMapping.put("error",userNotFound.getMessage());
        return errorMapping;
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MultipleEntries.class)
    public ResponseEntity<Map<String ,String>> userNotFount(MultipleEntries multipleEntries) {
        Map<String, String> errorMapping = new HashMap<>();
        errorMapping.put("error",multipleEntries.getMessage());
        return ResponseEntity.ok().body(errorMapping);
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> anyOtherError(Exception exception) {
        Map<String, String> errorMapping = new HashMap<>();
        errorMapping.put("error",exception.getMessage());
        return errorMapping;
    }
}
