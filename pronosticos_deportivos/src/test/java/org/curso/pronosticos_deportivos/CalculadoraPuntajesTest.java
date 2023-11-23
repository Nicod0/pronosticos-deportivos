package org.curso.pronosticos_deportivos;

import java.io.File;
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

        List<Partido> partido = partidos.leerPartidoCsv("."+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Resultados.csv");
        List<Pronostico> pronostico = pronosticos.leerPronosticoCsv("."+ File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Pronosticos.csv", partido);

        assertEquals(3, CalculadoraPuntajes.calcularPuntaje(pronostico, partido));
    }
}
