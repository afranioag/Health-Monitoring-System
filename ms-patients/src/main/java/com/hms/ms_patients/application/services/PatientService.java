package com.hms.ms_patients.application.services;

import com.hms.ms_patients.application.dtos.PatientDto;
import com.hms.ms_patients.model.entities.Patient;
import com.hms.ms_patients.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient save(PatientDto patientDto) {
        log.info("Save patient {}", patientDto);
        Patient patient = patientDto.newPatient();
        return patientRepository.save(patient);
    }

    public Patient getPatient(UUID id) {
        log.info("Get patient {}", id);
        return patientRepository.findById(id).orElse(null);
    }
}
