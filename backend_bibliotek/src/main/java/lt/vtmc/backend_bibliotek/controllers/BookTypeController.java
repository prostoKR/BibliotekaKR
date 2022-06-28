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

import lt.vtmc.backend_bibliotek.models.BookType;
import lt.vtmc.backend_bibliotek.payload.BookTypeRequest;
import lt.vtmc.backend_bibliotek.repository.BookTypeRepository;



@CrossOrigin("*")
@RestController
@RequestMapping("/booktypes")

public class BookTypeController {
	@Autowired 
	public BookTypeRepository bookTypeRepo;
	
	@GetMapping
	public List<BookType> getProducer() {
		return bookTypeRepo.findAll();

	}

	@GetMapping("/{id}")
	public BookType getProducer(@PathVariable Long id) {
		return bookTypeRepo.findById(id).get();
	}

	@PostMapping
	public BookType postProducer(@RequestBody BookTypeRequest bookTypeRequest) {
		System.out.println("CREATE: " + bookTypeRequest.getName());
		BookType bookType = new BookType();
		bookType.setName(bookTypeRequest.getName());
		
		return bookTypeRepo.save(bookType);
	}

	@DeleteMapping("/{id}")
	public void bookType(@PathVariable Long id) {
		bookTypeRepo.deleteById(id);
	}
	
//	ResponseEntity
	@PutMapping("/{id}")
	public ResponseEntity<BookType> updateProducers(@PathVariable Long id, @RequestBody BookType producerDetails) {
		BookType bookType = bookTypeRepo.findById(id).orElseThrow() ;
		
		bookType.setName(bookTypeDetails.getName());
	
		final BookType updatedBookType = bookTypeRepo.save(bookType);
        return ResponseEntity.ok(updatedBookType);
	}
}