package org.curso.pronosticos_deportivos.servicios;

import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.Pronostico;

import java.util.*;
import java.util.stream.Collectors;

public class CalculadoraPuntajes {

  public static List<Puntaje> calcularPuntajes(List<Pronostico> pronosticos, List<Partido> partidos) {

    // Armo una lista con todos los participantes existentes
    List<String> participantes = pronosticos
        .stream()
        .map(pronostico -> pronostico.getPersona())
        .distinct()
        .collect(Collectors.toList());

    // Por cada uno, creo un objeto Puntaje que tenga su nombre y su puntaje, y lo agrego a una lista de puntajes
    List<Puntaje> puntajes = new ArrayList<>();
    participantes.forEach(participante -> puntajes.add(new Puntaje(participante, calcularPuntajeDe(participante, pronosticos))));

    // Ordeno los objetos Puntaje según sus puntos, en forma descendente
    puntajes.sort(Comparator.comparingInt(Puntaje::getPuntos).reversed());

    return puntajes;
  }

  public static void mostrar(List<Puntaje> puntajes) {
    puntajes.forEach(puntaje -> System.out.println(puntaje.getPersona() + ": " + puntaje.getPuntos()));
  }

  public static Integer calcularPuntajeDe(String persona, List<Pronostico> pronosticos) {
    List<Pronostico> pronosticosDeLaPersona = getPronosticosFrom(persona, pronosticos);
    Integer puntaje = pronosticosDeLaPersona
        .stream()
        .mapToInt(pronostico -> pronostico.puntaje())
        .sum();

    return puntaje;
  }

  public static List<Pronostico> getPronosticosFrom(String persona, List<Pronostico> pronosticos) {
    return pronosticos
        .stream()
        .filter(pronostico -> pronostico.getPersona().equals(persona))
        .collect(Collectors.toList());
  }

  public static List<Pronostico> getPronosticosFromRound(String ronda, List<Pronostico> pronosticos) {
    return pronosticos
        .stream()
        .filter(pronostico -> pronostico.getRonda().getNroRonda().equals(ronda))
        .collect(Collectors.toList());
  }

  public static List<Pronostico> getPronosticosFromPhase(String fase, List<Pronostico> pronosticos) {
    return pronosticos
        .stream()
        .filter(pronostico -> pronostico.getRonda().getFase().equals(fase))
        .collect(Collectors.toList());
  }
}
