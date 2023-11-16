package ru.example.ealab1.repositories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;
import ru.example.ealab1.models.DepartmentEntity;

import java.util.List;
import java.util.UUID;

@Stateless
public class DepartmentRepository {
    @PersistenceContext
    private EntityManager em;

    public List<DepartmentEntity> findAll() {
        return em.createQuery("select i from DepartmentEntity i", DepartmentEntity.class).getResultList();
    }

    public void persist(DepartmentEntity entity) {
        em.persist(entity);
    }

    public void delete(UUID departmentId) {
        DepartmentEntity entity = em.find(DepartmentEntity.class, departmentId);
        em.remove(entity);
    }
}
