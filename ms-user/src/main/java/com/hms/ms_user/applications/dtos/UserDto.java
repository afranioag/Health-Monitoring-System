package com.hms.ms_user.applications.dtos;

import com.hms.ms_user.domain.entities.User;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String phoneNumber;

    public User getUser() {
        return User
                .builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
