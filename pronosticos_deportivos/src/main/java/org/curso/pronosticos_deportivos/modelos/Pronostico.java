package org.curso.pronosticos_deportivos.modelos;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;
import org.curso.pronosticos_deportivos.excepciones.FaltanDatosExcepcion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class Pronostico {
	
	private Partido partido;
	private ResultadoEnum resultado;
 
} 