package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.DoctorDepartment;
import com.np.hospital.management.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Integer> {
}
