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
	public Book getBook(@PathVariable Long id) {
		return bookRepo.findById(id).get();
	}

	@PostMapping
	public Book postFilm(@RequestBody BookRequest bookRequest) {
		Book book = new Book();
		book.setTitle(bookRequest.getTitle());
		book.setStoryline(bookRequest.getStoryline());
		BookType bookType = bookTypeRepo.findBookTypeByName(bookRequest.getBookTypeName()).orElseThrow();
		book.setBookType(bookType);
		return bookRepo.save(book);
	}

	@DeleteMapping("/{id}")
	
	public void deleteBook(@PathVariable Long id) {
		bookRepo.deleteById(id);
	}
	
//	ResponseEntity
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBooks(@PathVariable Long id, @RequestBody BookRequest bookDetails) {
		Book book = bookRepo.findById(id).orElseThrow() ;
	
		book.setTitle(bookDetails.getTitle());
		book.setStoryline(bookDetails.getStoryline());
		BookType bookType = bookTypeRepo.findProducerByName(bookDetails.getBookTypeName()).orElseThrow();
		book.setBookType(bookType);
		
		final Book updatedFilm = bookRepo.save(book);
        return ResponseEntity.ok(updatedBook);
	}
}
