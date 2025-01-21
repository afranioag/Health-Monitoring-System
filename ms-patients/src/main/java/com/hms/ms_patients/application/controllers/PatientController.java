package com.hms.ms_patients.application.controllers;

import com.hms.ms_patients.application.services.PatientService;
import com.hms.ms_patients.application.dtos.PatientDto;
import com.hms.ms_patients.domain.model.entities.Patient;
import com.hms.ms_patients.domain.security.anotations.Authenticated;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> addPatient(@RequestBody PatientDto patientDto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(patientService.save(patientDto));
    }

    @GetMapping(value = "/{id}")
    @Authenticated(value = "ADMIN")
    public ResponseEntity<Patient> getPatient(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }
}
