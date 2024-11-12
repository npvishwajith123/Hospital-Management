package com.np.hospital.management.controller;

import com.np.hospital.management.entities.Users;
import com.np.hospital.management.repositories.DoctorRepository;
import com.np.hospital.management.repositories.HospitalDbRepository;
import com.np.hospital.management.repositories.UserRepository;
import com.np.hospital.management.utilities.JWTUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PublicAPIController {

    private final UserRepository userRepository;
    private final JWTUtility jwtUtility;
    private final HospitalDbRepository hospitalRepository;

    private final DoctorRepository doctorRepository;

    @PostMapping("/api/public/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        Users userDetails = userRepository.findByUserName(user.getUserName()).orElseThrow(
                () -> new BadCredentialsException("Invalid Credentials"));
        if(userDetails.getPassword().equalsIgnoreCase(user.getPassword())) {
            return ResponseEntity.ok(jwtUtility.generateToken(userDetails));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }

    @GetMapping("/api/public/hospital/info")
    public ResponseEntity<?> getHospInfo() {
        return ResponseEntity.ok(hospitalRepository.findAll());
    }

    @GetMapping("/api/public/doctors/list")
    public ResponseEntity<?> getDocsInfo() {
        return ResponseEntity.ok(doctorRepository.findAll());
    }

}
