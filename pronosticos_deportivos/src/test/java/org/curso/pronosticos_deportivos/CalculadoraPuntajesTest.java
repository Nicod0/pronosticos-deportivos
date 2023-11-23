package org.curso.pronosticos_deportivos;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.Pronostico;
import org.curso.pronosticos_deportivos.servicios.CalculadoraPuntajes;
import org.curso.pronosticos_deportivos.servicios.LectorArchivoCsv;

class CalculadoraPuntajesTest {
    @Test
    void deberiaRetornarTres() {
        LectorArchivoCsv partidos = new LectorArchivoCsv();
        LectorArchivoCsv pronosticos = new LectorArchivoCsv();

        List<Partido> partido = partidos.leerPartidoCsv("/mnt/WDbk/Users/Hernan/Documents/Neoris-UTN/pronosticos-deportivos/pronosticos_deportivos/src/main/resources/Resultados.csv");
        List<Pronostico> pronostico = pronosticos.leerPronosticoCsv("/mnt/WDbk/Users/Hernan/Documents/Neoris-UTN/pronosticos-deportivos/pronosticos_deportivos/src/main/resources/Pronosticos.csv", partido);

        assertEquals(3, CalculadoraPuntajes.calcularPuntaje(pronostico, partido));
    }
}
