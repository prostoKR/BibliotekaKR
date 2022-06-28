package lt.vtmc.backend_bibliotek.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.vtmc.backend_bibliotek.models.Book;
import lt.vtmc.backend_bibliotek.models.BookType;
import lt.vtmc.backend_bibliotek.payload.BookRequest;
import lt.vtmc.backend_bibliotek.repository.BookRepository;
import lt.vtmc.backend_bibliotek.repository.BookTypeRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookTypeRepository bookTypeRepo;
 
	@GetMapping
	public List<Book> getBook() {
		return bookRepo.findAll();

	}

	@GetMapping("/{id}")
	public Book getFilm(@PathVariable Long id) {
		return bookRepo.findById(id).get();
	}

	@PostMapping
	public Book postFilm(@RequestBody BookRequest filmRequest) {
		Book book = new Book();
		book.setTitle(bookRequest.getTitle());
		book.setStoryline(bookRequest.getStoryline());
		BookType bookType = producerRepo.findProducerByName(filmRequest.getProducerName()).orElseThrow();
		film.setProducer(producer);
		return filmRepo.save(film);
	}

	@DeleteMapping("/{id}")
	
	public void deleteFilm(@PathVariable Long id) {
		filmRepo.deleteById(id);
	}
	
//	ResponseEntity
	@PutMapping("/{id}")
	public ResponseEntity<Film> updateFilms(@PathVariable Long id, @RequestBody FilmRequest filmDetails) {
		Film film = filmRepo.findById(id).orElseThrow() ;
	
		film.setTitle(filmDetails.getTitle());
		film.setStoryline(filmDetails.getStoryline());
		Producer producer = producerRepo.findProducerByName(filmDetails.getProducerName()).orElseThrow();
		film.setProducer(producer);
		
		final Film updatedFilm = filmRepo.save(film);
        return ResponseEntity.ok(updatedFilm);
	}
}
