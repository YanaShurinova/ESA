package ru.example.ealab1.department;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.example.ealab1.models.DepartmentEntity;
import ru.example.ealab1.models.dto.DepartmentRequest;

import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Stateless
public class DepartmentService {

    @Inject
    private DepartmentRepository departmentRepository;


    public List<DepartmentEntity> getAll() {
        return departmentRepository.findAll();
    }

    public UUID create(DepartmentRequest departmentRequest) {
        DepartmentEntity department = new DepartmentEntity(randomUUID(), departmentRequest.getName());
        departmentRepository.persist(department);
        return department.getId();
    }

    public void delete(UUID departmentId) {
        departmentRepository.delete(departmentId);
    }

}
