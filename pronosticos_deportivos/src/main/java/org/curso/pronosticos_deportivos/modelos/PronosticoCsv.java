package org.curso.pronosticos_deportivos.modelos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PronosticoCsv {

	@CsvBindByPosition(position = 0, required = true)
	private String nombreJugador;
	
	@CsvBindByPosition(position = 1, required = true)
	private String nombreEquipo1;
	
	@CsvBindByPosition(position = 2)
	private String ganaEquipo1;
	
	@CsvBindByPosition(position = 3)
	private String empate;
	
	@CsvBindByPosition(position = 4)
	private String ganaEquipo2; 
	
	@CsvBindByPosition(position = 5, required = true)
	private String nombreEquipo2;
	
}
