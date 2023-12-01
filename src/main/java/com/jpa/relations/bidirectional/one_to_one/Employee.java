package com.jpa.relations.bidirectional.one_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//ONE
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bi_Employee_one_to_one")
@Table(name = "bi_Employee_one_to_one")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "parking_spot_id")
	private ParkingSpot parkingSpot;
}
