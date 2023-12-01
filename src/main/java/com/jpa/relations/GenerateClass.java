package com.jpa.relations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateClass {
	
	public static void readTxt(String archivo, String paquete) {
		 try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String line;
	            
	            Entity entidad = null;
	            while ((line = br.readLine()) != null) {
	                String[] palabras = line.split("\n\\s*");
	                
	                if (line.startsWith("-")) entidad = new Entity(line.replaceAll("-", ""));

	                for (String palabra : palabras) {
	                	
	                	if (palabra.contains("\t") && !palabra.trim().isEmpty()) entidad.attributes.add(palabra);	
	                	if (palabra.trim().isEmpty()) generarClase(projectRoot(), paquete, entidad);
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static String projectRoot() {
		
		String root = null;
		
		try {
			OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
			Process process = null;
			if (osBean.getName().equals("Linux")) process = Runtime.getRuntime().exec("pwd");
			if (osBean.getName().equals("Windows")) process = Runtime.getRuntime().exec("cd");
			
			BufferedReader lector = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String linea;
			StringBuilder salida = new StringBuilder();
			while ((linea = lector.readLine()) != null) {
               salida.append(linea);
			}    
			root = salida.toString();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return root;
	}
		
	private static String generateClassStructured(Entity entity, String paquete) {
		String strcutured = paquete(paquete)
				+"\n"
				+ "\n"
				+ "\n"
				+ imports()
				+ "\n"
				+ annotationsClass(entity.name)
				+ "public class "+entity.name+" {\n"
				+ "	\n"
				+ id()
				+ "\n"
				+ "\n"
				+ attributes(entity.attributes)
				+ "}";
		
		return strcutured;
	}
	
	private static String generateInterfaceRepository(Entity entity, String paquete) {
		String strcutured = "package "+paquete+";\n"
				+ "\n"
				+ "import org.springframework.data.jpa.repository.JpaRepository;\n"
				+ "import org.springframework.stereotype.Repository;\n"
				+ "\n"
				+ "import "+paquete+"."+entity.name+";\n"
				+ "\n"
				+ "@Repository\n"
				+ "public interface "+entity.name+"Repository extends JpaRepository<"+entity.name+", Long>{\n"
				+ "	\n"
				+ "}\n"
				+ "";
				
		return strcutured;
	}
	
	private static String attributes(List<String> attributes) {
			String attrs = "";
			
			for (String atribute: attributes) {
				String[] datos = atribute.split(" ");
				
				attrs += "\tprivate String " +datos[0].trim() +";\n\n";	
			}
			
			return attrs;
	}
	
	private static String paquete(String p) {
		String packet = "package " + p +";";
		return packet;
	}
	
	private static void generarClase(String rutaProyecto, String paquete, Entity entidad) {
		
        String contenido = generateClassStructured(entidad, paquete);
        String interfaceContent = generateInterfaceRepository(entidad, paquete);

        Map<Path, String> archivosJava = new HashMap();
        
        String rutaClase = rutaProyecto + "/src/main/java/" + paquete.replace('.', '/') + "/" + entidad.name + ".java";
        String rutaInterface = rutaProyecto + "/src/main/java/" + paquete.replace('.', '/') + "/" + entidad.name + "Repository.java";
        
        Path path = Paths.get(rutaClase);
        Path pathInterface = Paths.get(rutaInterface);
        
        archivosJava.put(path, contenido);
        archivosJava.put(pathInterface, interfaceContent);

        archivosJava.forEach((k,v) -> {
        	
        	try {
        		if (!Files.exists(k)) Files.createDirectories(k.getParent());
        		
        		Files.write(k, v.getBytes());
        		System.out.println("Clase generada: " + k.getParent() + "/"+ k.getFileName());
        	} catch (IOException e) {
        		e.printStackTrace();
        		System.out.println(e.getMessage());
        		System.out.println("error");
        	}
        });
    }
	
	private static String annotationsClass(String name) {
		
		String lombokAnnotation=	"@Data\n"
			+ "@AllArgsConstructor\n"
			+ "@NoArgsConstructor\n"
			+ "@Entity\n"
			+ "@Table(name = "+"\""+name+"\""+")"
			+ "\n";
		
		return lombokAnnotation;
	}
	
	private static String imports() {
		String importClass =	"import jakarta.persistence.*;\n"
			+ "import lombok.*;\n";
		return importClass;
	}
	
	private static String id() {
		String primaryKey = "\t@Id\n"
				+ "\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n"
				+ "\tprivate Long id;"; 
		return primaryKey;
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
