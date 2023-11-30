package ru.example.ealab1.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.example.ealab1.models.DepartmentEntity;
import ru.example.ealab1.models.dto.DepartmentRequest;
import ru.example.ealab1.services.DepartmentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DepartmentEntity> getAll() {
        return departmentService.getAll();
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void create(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.create(departmentRequest);
    }

    @DeleteMapping("/{departmentId}")
    public void delete(@PathVariable UUID departmentId) {
        departmentService.delete(departmentId);
    }
}
