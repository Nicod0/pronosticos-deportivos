package org.curso.pronosticos_deportivos.modelos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Ronda {

	private Integer numero;
	private List<Partido> partidos;
	
	
	@Override
	public String toString() {
		return "Ronda numero=" + numero + "\nPartidos=" + 
				partidos.toString();
	}
	
}
