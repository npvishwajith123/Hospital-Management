package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.DoctorDepartment;
import com.np.hospital.management.entities.HospitalDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalDbRepository extends JpaRepository<HospitalDatabase, Integer> {
}
