package org.curso.pronosticos_deportivos.modelos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Ronda {
  private final String fase;
  private final String nroRonda;
  private List<Partido> partidos = new ArrayList<>();

  public Ronda(String fase, String nroRonda) {
    this.fase = fase;
    this.nroRonda = nroRonda;
  }

  private int puntosPorFase() {
    return 5;
    //ConfigCsv.puntosporRonda();
  }

  private int puntosPorRonda() {
    return 2;
  }

  public void agregarPartido(Partido unPartido) {
    this.partidos.add(unPartido);
  }
}
