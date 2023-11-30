package ru.example.ealab1.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.example.ealab1.repositories.DepartmentRepository;
import ru.example.ealab1.models.DepartmentEntity;
import ru.example.ealab1.models.dto.DepartmentRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;


    public List<DepartmentEntity> getAll() {
        return departmentRepository.getAll();
    }

    @Transactional
    public UUID create(DepartmentRequest departmentRequest) {
        DepartmentEntity department = new DepartmentEntity(randomUUID(), departmentRequest.getName());
        departmentRepository.persist(department);
        return department.getId();
    }

    @Transactional
    public void delete(UUID departmentId) {
        departmentRepository.delete(departmentId);
    }

}
