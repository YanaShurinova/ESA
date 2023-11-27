package ru.example.ealab1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.ealab1.models.dto.DepartmentRequest;
import ru.example.ealab1.services.DepartmentService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final ObjectMapper objectMapper;

    private final DepartmentService departmentService;

    @GetMapping("/departments")
    @SneakyThrows
    public ResponseEntity<String> getAll() {
        return new ResponseEntity<>(objectMapper.writeValueAsString(departmentService.getAll()), HttpStatus.OK);
    }

    @PostMapping("/departments")
    @SneakyThrows
    public ResponseEntity <?> create(@RequestBody String departmentRequestString) {

        DepartmentRequest departmentRequest = objectMapper.readValue(departmentRequestString,
                DepartmentRequest.class);
        departmentService.create(departmentRequest);
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @DeleteMapping("/departments/{departmentIdString}")
    public ResponseEntity <?> delete(@PathVariable String departmentIdString) {
        UUID departmentId = UUID.fromString(departmentIdString);
        departmentService.delete(departmentId);
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
