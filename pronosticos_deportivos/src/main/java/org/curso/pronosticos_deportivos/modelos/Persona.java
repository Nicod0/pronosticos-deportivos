package org.curso.pronosticos_deportivos.modelos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Persona {

	private String dni;
	private String nombre;
	private List<Pronostico> pronosticos;
	
}
