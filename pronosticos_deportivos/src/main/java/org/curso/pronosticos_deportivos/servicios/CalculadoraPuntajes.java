package org.curso.pronosticos_deportivos.servicios;

import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.Pronostico;

import java.util.List;

public class CalculadoraPuntajes {

  public static int calcularPuntaje(List<Pronostico> pronosticos, List<Partido> partidos) {
    int puntaje = pronosticos
        .stream()
        .mapToInt(pronostico -> pronostico.puntaje())
        .sum();
    return puntaje;
  }

}
