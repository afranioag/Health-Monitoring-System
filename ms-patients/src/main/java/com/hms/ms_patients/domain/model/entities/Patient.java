package com.hms.ms_patients.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.ms_patients.domain.model.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 60)
    private String name;

    @Column(unique = true, length = 15)
    private String document;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern =  "yyyy-MM-dd")
    private LocalDate birthdate;

    @Column(length = 20)
    private String phone;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private BasicUser basicUser;
}
