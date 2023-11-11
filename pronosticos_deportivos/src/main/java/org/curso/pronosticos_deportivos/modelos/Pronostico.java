package org.curso.pronosticos_deportivos.modelos;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Pronostico {
	
	private Partido partido;
	private ResultadoEnum resultado;
	
	public Pronostico(PronosticoCsv pronosticoCsv, List<Partido> partidos) {
		Partido partidoPronosticado = partidos
				.stream()
				.filter(partido -> partido.getEquipo1().getNombre().equalsIgnoreCase(pronosticoCsv.getNombreEquipo1()))
				.filter(partido -> partido.getEquipo2().getNombre().equalsIgnoreCase(pronosticoCsv.getNombreEquipo2()))
				.findFirst()
				.orElse(new Partido());

		this.setPartido(partidoPronosticado);
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

	public Integer puntaje() {
			if (this.hayAcierto()) {
				return 1;
			}
			return 0;
	}

	public Boolean hayAcierto() {
		if (this.resultado == this.partido.resultado()) {
			return true;
		}
		return false;
	}
 
} 