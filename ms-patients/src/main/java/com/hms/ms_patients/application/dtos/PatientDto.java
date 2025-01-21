package com.hms.ms_patients.application.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hms.ms_patients.domain.model.entities.Patient;
import com.hms.ms_patients.domain.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String document;
    private Gender gender;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern =  "yyyy-MM-dd")
    private LocalDate birthdate;
    private String phone;

    public Patient newPatient() {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setDocument(document);
        patient.setGender(gender);
        patient.setBirthdate(birthdate);
        patient.setPhone(phone);
        return patient;
    }


}
