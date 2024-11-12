package com.np.hospital.management.repositories;

import com.np.hospital.management.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUserName(String userName);
}
