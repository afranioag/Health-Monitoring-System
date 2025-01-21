package com.hms.ms_patients.application.dtos;

import com.hms.ms_patients.domain.model.entities.BasicUser;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
public class BasicUserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String email;
    private String phoneNumber;

    public BasicUser toBasicUser() {
        return new BasicUser(id, email, phoneNumber);
    }

}
