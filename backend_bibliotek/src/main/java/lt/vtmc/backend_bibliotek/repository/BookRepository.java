package lt.vtmc.backend_bibliotek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.vtmc.backend_bibliotek.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
