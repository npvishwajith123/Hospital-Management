package com.np.hospital.management.controller;

import com.np.hospital.management.entities.DoctorDepartment;
import com.np.hospital.management.entities.DoctorRecords;
import com.np.hospital.management.repositories.DepartmentRepository;
import com.np.hospital.management.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminAPIController {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    @PostMapping("/api/auth/admin/department/add")
    public ResponseEntity<?> addDepartment(@RequestBody DoctorDepartment department) {
        DoctorDepartment save = departmentRepository.save(department);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/api/auth/admin/doctor/add")
    public ResponseEntity<?> addDoctor(@RequestBody DoctorRecords doctor) {
        DoctorRecords save = doctorRepository.save(doctor);
        return ResponseEntity.ok(save);
    }
}
