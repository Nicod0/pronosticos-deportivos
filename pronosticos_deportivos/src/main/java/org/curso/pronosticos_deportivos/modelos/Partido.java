package org.curso.pronosticos_deportivos.modelos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Partido {

	@CsvBindByPosition(position = 0)
	private Integer ronda;
	
	@CsvBindByPosition(position = 1)
	private String NombreEquipo1;
	
	@CsvBindByPosition(position = 2)
	private Integer golesEquipo1;
	
	@CsvBindByPosition(position = 3)
	private Integer golesEquipo2;
	
	@CsvBindByPosition(position = 4)
	private String NombreEquipo2;
	
}
