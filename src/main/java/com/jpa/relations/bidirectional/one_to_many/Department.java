package com.jpa.relations.bidirectional.one_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//ONE
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bi_Department_one_to_many")
@Table(name = "bii_Department_one_to_many")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "department")
	private List<Employee> employeeList;
}
