package org.curso.pronosticos_deportivos.modelos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor 
public class Equipo {

	private String nombre;
	private String descripcion;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
}
