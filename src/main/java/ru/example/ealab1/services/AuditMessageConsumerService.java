package ru.example.ealab1.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import ru.example.ealab1.models.AuditEntity;
import ru.example.ealab1.models.AuditMessage;
import ru.example.ealab1.repositories.AuditRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuditMessageConsumerService {
    private final AuditRepository auditRepository;

    @Transactional
    @JmsListener(destination = "${application.topic.audit}")
    public void receive(AuditMessage auditMessage) {
        AuditEntity audit = new AuditEntity();
        audit.setId(UUID.randomUUID());
        audit.setEvent(auditMessage.getEvent());
        audit.setTable(auditMessage.getTable());
        audit.setDatetime(auditMessage.getDatetime());
        audit.setInfo(auditMessage.getInfo());

        auditRepository.persist(audit);
    }
}
