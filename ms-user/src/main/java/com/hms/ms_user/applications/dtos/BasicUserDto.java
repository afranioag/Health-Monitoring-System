package com.hms.ms_user.applications.dtos;

import com.hms.ms_user.domain.entities.User;
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

    public BasicUserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
