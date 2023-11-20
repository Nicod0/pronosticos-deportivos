package org.curso.pronosticos_deportivos.modelos;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEquipo1;
	private Integer golesEquipo2;
	
	public ResultadoEnum resultado() {
		
		if(this.getGolesEquipo1() > this.getGolesEquipo2()) {
			return ResultadoEnum.LOCAL;
		}  
		
		if(this.getGolesEquipo1() < this.getGolesEquipo2()) {
			return ResultadoEnum.VISITANTE;
		}
		
		return ResultadoEnum.EMPATE;
	}

	@Override
	public String toString() {
		return equipo1.getNombre() + " " + golesEquipo1 + " | " + golesEquipo2
				+ " " + equipo2.getNombre();
	}
	
	
}
