package com.jpa.relations.unidirectional.one_to_one;

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
@Entity(name = "uni_ParkingSpot_one_to_one")
@Table(name = "uni_ParkingSpot_one_to_one")
public class ParkingSpot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
}
