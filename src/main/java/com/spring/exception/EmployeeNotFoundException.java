package com.spring.exception;

public class EmployeeNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private Object fieldValue;

    public EmployeeNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
