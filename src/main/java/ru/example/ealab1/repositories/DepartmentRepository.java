package ru.example.ealab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.example.ealab1.models.DepartmentEntity;

import java.util.List;
import java.util.UUID;

@Repository
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<DepartmentEntity> getAll() {
        return em.createQuery("select i from DepartmentEntity i", DepartmentEntity.class).getResultList();
    }

    public void persist(DepartmentEntity entity) {
        em.persist(entity);
    }

    public DepartmentEntity delete(UUID departmentId) {
        DepartmentEntity entity = em.find(DepartmentEntity.class, departmentId);
        em.remove(entity);
        return entity;
    }
}
