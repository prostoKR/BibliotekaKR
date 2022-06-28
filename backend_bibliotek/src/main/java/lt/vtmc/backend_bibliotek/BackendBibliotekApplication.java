package lt.vtmc.backend_bibliotek;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lt.vtmc.backend_bibliotek.models.ERole;
import lt.vtmc.backend_bibliotek.models.Role;
import lt.vtmc.backend_bibliotek.repository.RoleRepository;

@SpringBootApplication
public class BackendBibliotekApplication{

	public static void main(String[] args) {
		SpringApplication.run(BackendBibliotekApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialData(RoleRepository roleRepo) {
		return args -> {
			if (roleRepo.findByName(ERole.ROLE_USER).isEmpty()) {
				roleRepo.save(new Role(ERole.ROLE_USER));
			}
			if (roleRepo.findByName(ERole.ROLE_ADMIN).isEmpty()) {
				roleRepo.save(new Role(ERole.ROLE_ADMIN));
			}
		};
	}

}
