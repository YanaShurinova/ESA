package ru.example.ealab1.services;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.example.ealab1.models.AuditEvent;
import ru.example.ealab1.models.AuditMessage;
import ru.example.ealab1.models.CreateMessage;
import ru.example.ealab1.models.DeleteMessage;
import ru.example.ealab1.utils.EventLogger;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuditProducerService implements EventLogger {

    private final JmsTemplate jmsTemplate;

    @Value("${application.topic.audit}")
    private String topicName;

    @Override
    public void log(Object entity, AuditEvent event) {
        AuditMessage auditMessage = null;

        switch (event) {
            case CREATE -> {
                CreateMessage createMessage = new CreateMessage();
                createMessage.setCreatedObject(entity);
                auditMessage = createMessage;
            }
            case DELETE -> {
                DeleteMessage deleteMessage = new DeleteMessage();
                deleteMessage.setDeletedObject(entity);
                auditMessage = deleteMessage;
            }
        }

        auditMessage.setDatetime(LocalDateTime.now());
        auditMessage.setEvent(event);

        auditMessage.setTable(entity.getClass().getAnnotation(Table.class).name());

        jmsTemplate.convertAndSend(topicName, auditMessage);
    }


}
