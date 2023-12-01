package com.jpa.relations.bidirectional.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//MANY
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bi_Author_many_to_many")
@Table(name = "bi_Author_many_to_many")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "authorList")
	private List<Book> bookList;
}
