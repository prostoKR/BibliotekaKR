package lt.vtmc.backend_bibliotek.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lt.vtmc.backend_bibliotek.models.BookType;

@Data
@NoArgsConstructor
@Entity
public class BookType {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public BookType(String name) {
		this.name = name;
	}

}