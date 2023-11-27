package ru.example.ealab1.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.example.ealab1.repositories.EmployeeRepository;
import ru.example.ealab1.models.EmployeeEntity;
import ru.example.ealab1.models.dto.EmployeeRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }

    public UUID create(EmployeeRequest employeeRequest) {
        EmployeeEntity employee = new EmployeeEntity(randomUUID(), employeeRequest.getName(), employeeRequest.getAge(), employeeRequest.getDepartmentId());
        employeeRepository.persist(employee);
        return employee.getId();
    }

    public void delete(UUID employeeId) {
        employeeRepository.delete(employeeId);
    }
}

