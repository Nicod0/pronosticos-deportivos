package org.curso.pronosticos_deportivos;

import org.curso.pronosticos_deportivos.modelos.Persona;
import org.curso.pronosticos_deportivos.modelos.Ronda;
import org.curso.pronosticos_deportivos.servicios.CalculadoraPuntajes;
import org.curso.pronosticos_deportivos.servicios.LectorArchivoCsv;

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
        List<Ronda> rondas = null;
        List<Persona> personas = null;
        try {
        	rondas = lector.leerPartidoCsv(rutaAbsoluta + "\\src\\main\\resources\\resultados.csv");
            personas = lector.leerPronosticoCsv(rutaAbsoluta + "\\src\\main\\resources\\\\pronosticos.csv");
        } catch(FileNotFoundException e) {
        	e.getMessage();
        	e.getStackTrace();
        } catch (IOException e) {
        	e.getMessage();
        	e.getStackTrace();
		}
        
        CalculadoraPuntajes.motrarPuntajeFinal(rondas, personas);

    }
}
