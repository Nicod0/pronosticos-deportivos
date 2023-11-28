package org.curso.pronosticos_deportivos;

import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.Pronostico;
import org.curso.pronosticos_deportivos.servicios.CalculadoraPuntajes;
import org.curso.pronosticos_deportivos.servicios.LectorArchivoCsv;
import org.curso.pronosticos_deportivos.servicios.Puntaje;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        String rutaAbsoluta = System.getProperty("user.dir");
        System.out.println(rutaAbsoluta);
        LectorArchivoCsv lector = new LectorArchivoCsv();
        List<Partido> partidos = lector.leerPartidoCsv(rutaAbsoluta + "\\src\\main\\resources\\resultados.csv");
        List<Pronostico> pronosticos = lector.leerPronosticoCsv(rutaAbsoluta + "\\src\\main\\resources\\\\pronosticos.csv", partidos);

        List<Puntaje> puntajes = CalculadoraPuntajes.calcularPuntajes(pronosticos, partidos);
        CalculadoraPuntajes.mostrar(puntajes);
    }
}
