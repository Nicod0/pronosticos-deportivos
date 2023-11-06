package org.curso.pronosticos_deportivos.servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.curso.pronosticos_deportivos.modelos.Pronostico;
import org.curso.pronosticos_deportivos.modelos.Partido;

import com.opencsv.bean.CsvToBeanBuilder;

public class LectorArchivoCsv {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Partido> leerPartidoCsv(String rutaPartido) {
		
		List<Partido> lineasPartidoCsv = null;
		
		try {
			lineasPartidoCsv = new CsvToBeanBuilder(new FileReader(rutaPartido, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(Partido.class)
					.build().parse();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuantra el archivo especificado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		}
			
		return lineasPartidoCsv;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Pronostico> leerPronosticoCsv(String rutaPronostico) {
		
		List<Pronostico> lineasPronosticoCsv = null;
		
		try {
			lineasPronosticoCsv = new CsvToBeanBuilder(new FileReader(rutaPronostico, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(Pronostico.class)
					.build().parse();
		} catch (FileNotFoundException e) {
			System.out.println("No se encuantra el archivo especificado");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
			e.printStackTrace();
		}
			
		return lineasPronosticoCsv;
	}
	
}
