package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.DoctorDepartment;
import com.np.hospital.management.entities.DoctorRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorRecords, Integer> {
}
