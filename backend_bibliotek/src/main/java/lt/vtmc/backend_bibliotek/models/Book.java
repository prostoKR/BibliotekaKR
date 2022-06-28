package lt.vtmc.backend_bibliotek.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String storyline;
	
	@ManyToOne
	@JoinColumn(name="bookType_id")
	private BookType bookType;
	
	

}
