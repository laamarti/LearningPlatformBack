package com.trainings.platform.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainings.platform.Models.User;

public interface UserRepository extends JpaRepository<User,Long> {
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	Optional<User> findByUsername(String username);
	Boolean existsByEmail(String email);
	Boolean existsByUsername(String username);

}
