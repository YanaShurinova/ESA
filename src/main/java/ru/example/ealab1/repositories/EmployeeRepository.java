package ru.example.ealab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.example.ealab1.models.EmployeeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em;

    public List<EmployeeEntity> getAll() {
        return em.createQuery("select i from EmployeeEntity i", EmployeeEntity.class).getResultList();
    }

    public void persist(EmployeeEntity entity) {
        em.persist(entity);
    }

    public EmployeeEntity delete(UUID employeeId) {
        EmployeeEntity entity = em.find(EmployeeEntity.class, employeeId);
        em.remove(entity);
        return entity;
    }
}
