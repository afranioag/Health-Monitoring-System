package com.hms.ms_user.applications.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String type = "Bearer";
    private String accessToken;
    private long expiresAt;

}
