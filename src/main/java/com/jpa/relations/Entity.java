package com.jpa.relations;

import java.util.ArrayList;
import java.util.List;

public class Entity {
	
	String name;
	List<String> attributes;
	
	public Entity(String name) {
		this.attributes = new ArrayList<>();
		this.name = name;
	}
}
