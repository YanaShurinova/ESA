package ru.example.ealab1.models;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateMessage extends AuditMessage {

    private Object createdObject;

    @Override
    public String getInfo() {
        return "Был создан объект %s".formatted(createdObject);
    }

}
