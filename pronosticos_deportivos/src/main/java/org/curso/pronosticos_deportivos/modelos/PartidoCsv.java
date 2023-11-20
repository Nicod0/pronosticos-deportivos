package org.curso.pronosticos_deportivos.modelos;

import com.opencsv.bean.CsvBindByPosition;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class PartidoCsv {

	@CsvBindByPosition(position = 0, required = true)
	private Integer ronda;
	
	@CsvBindByPosition(position = 1, required = true)
	private String NombreEquipo1;
	
	@CsvBindByPosition(position = 2, required = true)
	private Integer golesEquipo1;
	
	@CsvBindByPosition(position = 3, required = true)
	private Integer golesEquipo2;
	
	@CsvBindByPosition(position = 4, required = true)
	private String NombreEquipo2;
	
}
