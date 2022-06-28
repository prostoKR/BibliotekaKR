package lt.vtmc.backend_bibliotek.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.backend_bibliotek.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}