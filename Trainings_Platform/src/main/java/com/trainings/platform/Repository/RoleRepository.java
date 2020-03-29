package com.trainings.platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.ERole;
import com.trainings.platform.Models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

}
