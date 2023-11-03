package org.curso.pronosticos_deportivos.modelos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Pronostico {

	@CsvBindByPosition(position = 0)
	private String nombreJugador;
	
	@CsvBindByPosition(position = 1)
	private String nombreEquipo1;
	
	@CsvBindByPosition(position = 2)
	private String ganaEquipo1;
	
	@CsvBindByPosition(position = 3)
	private String empate;
	
	@CsvBindByPosition(position = 4)
	private String ganaEquipo2; 
	
	@CsvBindByPosition(position = 5)
	private String nombreEquipo2;
	
}
