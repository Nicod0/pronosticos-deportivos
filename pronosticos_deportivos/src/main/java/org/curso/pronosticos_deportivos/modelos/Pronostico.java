package org.curso.pronosticos_deportivos.modelos;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pronostico {
	
	private Partido partido;
	private ResultadoEnum resultado;
	
	public Pronostico(PronosticoCsv pronosticoCsv) {
		Partido partido = new Partido();
		partido.setEquipo1(new Equipo(pronosticoCsv.getNombreEquipo1()));
		partido.setEquipo2(new Equipo(pronosticoCsv.getNombreEquipo2()));
		this.setPartido(partido);
		
		this.setResultado(convertirResultado(pronosticoCsv));
	}
	
	public ResultadoEnum convertirResultado(PronosticoCsv pronosticoCsv) {
		
		if(pronosticoCsv.getGanaEquipo1().equalsIgnoreCase("x")) {
			return ResultadoEnum.LOCAL;
		}
		
		if(pronosticoCsv.getGanaEquipo2().equalsIgnoreCase("x")) {
			return ResultadoEnum.VISITANTE;
		}
		
		return ResultadoEnum.EMPATE;
	}
 
}