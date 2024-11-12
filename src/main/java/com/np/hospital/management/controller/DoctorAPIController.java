package com.np.hospital.management.controller;


import com.np.hospital.management.entities.PatientRecords;
import com.np.hospital.management.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DoctorAPIController {

    private final PatientRepository patientRepository;

    @GetMapping("/api/auth/doctor/patient/records/{patientId}")
    public ResponseEntity<?> getPatientRecordForId(@PathVariable("patientId") String patientId) {
        try {
            return  ResponseEntity.ok(patientRepository.findById(Integer.parseInt(patientId)).orElseThrow(()
                                                -> new Exception("No Patient Records Found!!")));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(e.getMessage());
        }
    }

    //todo: How put works?, Do we've to passId in the request,
    // Do we've to fetch Id and check or just simply update the table?
    @PutMapping("/api/auth/doctor/update/diagnosis")
    public ResponseEntity<?> updateDiagnosis(@RequestBody PatientRecords patientRecords) {
        PatientRecords save = patientRepository.save(patientRecords);
        return ResponseEntity.ok(save);
    }

}
