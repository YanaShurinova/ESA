package ru.example.ealab1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.example.ealab1.models.dto.EmployeeRequest;
import ru.example.ealab1.services.EmployeeService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final ObjectMapper objectMapper;

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(employeeService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/employees")
    @SneakyThrows
    public ResponseEntity <?> create(@RequestBody String employeeRequestString) {

        EmployeeRequest employeeRequest = objectMapper.readValue(employeeRequestString,
                EmployeeRequest.class);
        employeeService.create(employeeRequest);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeIdString}")
    public ResponseEntity <?> delete(@PathVariable String employeeIdString) {
        UUID employeeId = UUID.fromString(employeeIdString);
        employeeService.delete(employeeId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
