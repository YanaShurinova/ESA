package ru.example.ealab1.controllers;

import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.ealab1.models.EmployeeEntity;
import ru.example.ealab1.models.dto.EmployeeRequest;
import ru.example.ealab1.services.EmployeeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<EmployeeEntity> getAll() {
        return employeeService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void create(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.create(employeeRequest);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable UUID employeeId) {
        employeeService.delete(employeeId);
    }

}
