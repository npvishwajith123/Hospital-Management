package com.np.hospital.management.controller;

import com.np.hospital.management.entities.PatientRecords;
import com.np.hospital.management.repositories.DoctorRepository;
import com.np.hospital.management.repositories.PatientRepository;
import com.np.hospital.management.utilities.JWTUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PatientAPIController {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final JWTUtility jwtUtility;

    @GetMapping("/api/auth/patient/records")
    public ResponseEntity<?> viewPatientRecords() {
            return ResponseEntity.ok( patientRepository.findAll());
    }

    @PostMapping("/api/auth/patient/appointment")
    public ResponseEntity<?> bookAppointment(@RequestBody PatientRecords patient) {
        try {
            PatientRecords save = patientRepository.save(patient);
            return ResponseEntity.ok(save);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("Unable to book an appointment");
        }
    }
}
