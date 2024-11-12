package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.DoctorDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DoctorDepartment, Integer> {
}
