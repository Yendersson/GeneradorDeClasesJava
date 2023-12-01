package com.jpa.relations.unidirectional.many_to_one;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//TO ONE
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "uni_School_many_to_one")
@Table(name = "uni_School_many_to_one")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}
