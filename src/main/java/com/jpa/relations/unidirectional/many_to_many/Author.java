package com.jpa.relations.unidirectional.many_to_many;


import jakarta.persistence.*;
import lombok.*;
//MANY
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "uni_Author_many_to_many")
@Table(name = "uni_Author_many_to_many")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
