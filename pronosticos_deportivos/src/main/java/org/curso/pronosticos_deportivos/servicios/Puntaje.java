package org.curso.pronosticos_deportivos.servicios;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Puntaje {
  public String persona;
  public Integer puntos;

  public Puntaje(String persona, Integer puntos) {
    this.persona = persona;
    this.puntos = puntos;
  }

}
