package com.jpa.relations;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringDataJpaApplication.class, args);
        String archivo = "Clases.txt";
        String paquete = "com.jpa.relations.entities";
        GenerateClass.readTxt(archivo, paquete);
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println(osBean.getName());
	}

}
