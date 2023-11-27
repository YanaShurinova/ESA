package ru.example.ealab1.models.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeRequest {
    private String name;
    private int age;
    private UUID departmentId;
}
