package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.PatientRecords;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientRecords, Integer> {

    Optional<PatientRecords> findByName(String name);
}
