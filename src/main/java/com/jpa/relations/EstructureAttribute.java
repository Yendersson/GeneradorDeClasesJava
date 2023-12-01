package com.jpa.relations;

import java.util.ArrayList;
import java.util.List;

public class EstructureAttribute {

	private String line;
	 String type;
	 String name;
	 String entity;
	
	
	
	public static void main(String[] args) {
		
		EstructureAttribute ea = new EstructureAttribute("products type:list -Product");
	}
	
	public EstructureAttribute(String line) {
		this.line = line;
		assingAttr(line);
	}
	
	private void assingAttr(String line) {
		String[] properties = line.split(" ");
		
		this.name = properties[0];
		
		if (properties.length > 1) {
			for (String prop : properties) {
				if(prop.trim().startsWith("-")) this.entity = prop;
			}
			
			for (String prop : properties) {
				if(prop.trim().startsWith("type:")) this.type = prop.split(":")[1];
			}
		}
		
		System.out.println(this.name + ", " + this.entity + "," + this.type);
	}
	
	public static String dataType(String data, String entity) {
		
		switch (data) {
		case "int":
			return "Integer";
		case "long":
			return "Long";
		case "double":
			return "Double";
		case "set":
			return "Set<"+entity+">";
		case "list":
			return "List<"+entity+">";
		case "boolean":
			return "Boolean";
		default:
			return "String";
		}
}
	
	
}
