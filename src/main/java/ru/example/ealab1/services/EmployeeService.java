package ru.example.ealab1.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.ealab1.repositories.EmployeeRepository;
import ru.example.ealab1.models.EmployeeEntity;
import ru.example.ealab1.models.dto.EmployeeRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public UUID create(EmployeeRequest employeeRequest) {
        EmployeeEntity employee = new EmployeeEntity(randomUUID(), employeeRequest.getName(), employeeRequest.getAge(), employeeRequest.getDepartmentId());
        employeeRepository.persist(employee);
        return employee.getId();
    }
    @Transactional
    public void delete(UUID employeeId) {
        employeeRepository.delete(employeeId);
    }
}

