package org.curso.pronosticos_deportivos.servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.curso.pronosticos_deportivos.modelos.PronosticoCsv;
import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.PartidoCsv;
import org.curso.pronosticos_deportivos.modelos.Pronostico;

import com.opencsv.bean.CsvToBeanBuilder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LectorArchivoCsv {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Partido> leerPartidoCsv(String rutaPartido) {
		
		List<PartidoCsv> lineasPartidoCsv = null;
		List<Partido> partidos = new ArrayList<Partido>();
		
		try {
			lineasPartidoCsv = new CsvToBeanBuilder(new FileReader(rutaPartido))
      //lineasPartidoCsv = new CsvToBeanBuilder(new FileReader(rutaPartido, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(PartidoCsv.class)
					.build().parse();
			
			for(PartidoCsv partidoCsv : lineasPartidoCsv) {
				
				Partido partido = new Partido(partidoCsv);
				partidos.add(partido);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado");
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error al leer el archivo");
			ex.printStackTrace();
		}
			
		return partidos;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Pronostico> leerPronosticoCsv(String rutaPronostico, List<Partido> partidos) {
		
		List<PronosticoCsv> lineasPronosticoCsv = null;
		List<Pronostico> pronosticos = new ArrayList<Pronostico>();
		Set<String> personas = new HashSet<>();
		
		try {
			lineasPronosticoCsv = new CsvToBeanBuilder(new FileReader(rutaPronostico))
      //lineasPronosticoCsv = new CsvToBeanBuilder(new FileReader(rutaPronostico, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(PronosticoCsv.class)
					.build().parse();
			
			for (PronosticoCsv pronosticoCsv : lineasPronosticoCsv) {
				Pronostico pronostico = new Pronostico(pronosticoCsv, partidos);

				personas.add(pronosticoCsv.getNombreJugador());
				pronosticos.add(pronostico);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encuentra el archivo especificado");
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error al leer el archivo");
			ex.printStackTrace();
		}
			
		return pronosticos;
	}
	
}
