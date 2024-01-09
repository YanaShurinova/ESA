package ru.example.ealab1.utils;

import ru.example.ealab1.models.AuditEvent;

public interface EventLogger {

    void log(Object entity, AuditEvent event);

}
