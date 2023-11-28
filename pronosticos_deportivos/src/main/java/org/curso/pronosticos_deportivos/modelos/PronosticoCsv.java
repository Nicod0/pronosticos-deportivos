package org.curso.pronosticos_deportivos.modelos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PronosticoCsv {

	@CsvBindByPosition(position = 0, required = true)
	private String nombreJugador;

	@CsvBindByPosition(position = 1, required = true)
	private String fase;

	@CsvBindByPosition(position = 2, required = true)
	private String ronda;
	
	@CsvBindByPosition(position = 3, required = true)
	private String nombreEquipo1;
	
	@CsvBindByPosition(position = 4)
	private String ganaEquipo1;
	
	@CsvBindByPosition(position = 5)
	private String empate;
	
	@CsvBindByPosition(position = 6)
	private String ganaEquipo2; 
	
	@CsvBindByPosition(position = 7, required = true)
	private String nombreEquipo2;
	
}
