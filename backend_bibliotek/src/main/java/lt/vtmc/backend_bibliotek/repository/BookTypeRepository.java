package lt.vtmc.backend_bibliotek.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.backend_bibliotek.models.BookType;

public interface BookTypeRepository extends JpaRepository<BookType, Long> {

	Optional<BookType> findBookTypeByName(String bookTypeName);
	
	
}
