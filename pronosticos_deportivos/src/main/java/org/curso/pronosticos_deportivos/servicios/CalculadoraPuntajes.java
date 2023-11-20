package org.curso.pronosticos_deportivos.servicios;

import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.Persona;
import org.curso.pronosticos_deportivos.modelos.Pronostico;
import org.curso.pronosticos_deportivos.modelos.Ronda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculadoraPuntajes {

	public static void motrarPuntajeFinal(List<Ronda> rondas, List<Persona> personas) {

		// creo un map de rondas para separar cada Ronda por número
		Map<Integer, List<Partido>> mapRondas = rondas.stream()
				.collect(Collectors.toMap(Ronda::getNumero, Ronda::getPartidos));

		// creo un map de personas para separar cada Persona por nombre
		Map<String, List<Pronostico>> mapPersonas = personas.stream()
				.collect(Collectors.toMap(Persona::getNombre, Persona::getPronosticos));

		// recorro el map de personas y muestro el puntaje de cada persona
		for (Map.Entry<String, List<Pronostico>> entry : mapPersonas.entrySet()) {

			System.out.println("Nombre: " + entry.getKey() + " -> Puntaje: "
					+ sumarPuntajePorPersona(entry.getValue(), mapRondas));
		}

	}

	// si el resultado del partido es igual al pronostico sumamos 1
	private static int calcularPuntajeDePartido(Partido partido, Pronostico pronostico) {
		if (partido.resultado() == pronostico.getResultado()) {
			return 1;
		}
		return 0;
	}

	// sumamos el puntaje por Persona
	private static int sumarPuntajePorPersona(List<Pronostico> pronosticos, Map<Integer, List<Partido>> mapRondas) {

		int puntajePorPersona = 0;

		for (Map.Entry<Integer, List<Partido>> entry : mapRondas.entrySet()) {
			int sumaPartido = 0;
			for (Partido partido : entry.getValue()) {
				if (buscarPronostico(partido, pronosticos) != null) {
					sumaPartido += calcularPuntajeDePartido(partido, buscarPronostico(partido, pronosticos));
				}
			}
			puntajePorPersona += sumaPartido;
		}
		return puntajePorPersona;
	}

	// buscamos si el partido esta en la lista de pronosticos
	private static Pronostico buscarPronostico(Partido partido, List<Pronostico> pronosticos) {
		
		return pronosticos.stream()
	            .filter(pronostico -> pronostico.getPartido().getEquipo1().equals(partido.getEquipo1()))
	            .filter(pronostico -> pronostico.getPartido().getEquipo2().equals(partido.getEquipo2()))
	            .findFirst()
	            .orElse(null);
	}
}
