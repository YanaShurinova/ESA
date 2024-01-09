package ru.example.ealab1.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.example.ealab1.models.AuditEntity;


@Repository
public class AuditRepository {

    @PersistenceContext
    private EntityManager em;

    public void persist(AuditEntity entity) {
        em.persist(entity);
    }

}