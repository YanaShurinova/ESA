package ru.example.ealab1.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class EmployeeEntity {
    @Id
    @Column(name = "employee_id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name="department_id")
    private  UUID department_id;
}
