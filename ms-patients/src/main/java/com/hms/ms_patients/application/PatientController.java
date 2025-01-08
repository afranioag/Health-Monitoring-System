package com.hms.ms_patients.application;

import com.hms.ms_patients.model.dtos.PatientDto;
import com.hms.ms_patients.model.entities.Patient;
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
    public ResponseEntity<Patient> getPatient(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getPatient(id));
    }
}
