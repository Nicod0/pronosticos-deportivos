package org.curso.pronosticos_deportivos.servicios;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.curso.pronosticos_deportivos.modelos.PronosticoCsv;
import org.curso.pronosticos_deportivos.modelos.Ronda;
import org.curso.pronosticos_deportivos.excepciones.FaltanDatosExcepcion;
import org.curso.pronosticos_deportivos.modelos.PartidoCsv;
import org.curso.pronosticos_deportivos.modelos.Persona;

import com.opencsv.bean.CsvToBeanBuilder;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LectorArchivoCsv {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Ronda> leerPartidoCsv(String rutaPartido) throws IllegalStateException, IOException {

		List<PartidoCsv> lineasPartidoCsv = null;
		List<Ronda> rondas = new ArrayList<Ronda>();

		try {
			lineasPartidoCsv = new CsvToBeanBuilder(new FileReader(rutaPartido, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(PartidoCsv.class)
					.build().parse();

			// mapeo la lista del csv para agruparlos según el número de ronda
			Map<Integer, List<PartidoCsv>> partidosPorRonda = lineasPartidoCsv.stream()
					.collect(Collectors.groupingBy(PartidoCsv::getRonda));

			// recorro el Map y guardo los datos en Ronda
			for (Map.Entry<Integer, List<PartidoCsv>> entry : partidosPorRonda.entrySet()) {
				Ronda ronda = new Ronda();
				ronda.setNumero(entry.getKey());
				// al guardar la lista de partidos, transformo PartidoCsv a Partido
				ronda.setPartidos(entry.getValue().stream().map(partidoCsv -> ConvertirObjetoCsvAObjeto.partidoCsvAPartido(partidoCsv))
						.collect(Collectors.toList()));
				rondas.add(ronda);
			}

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se encuentra el archivo especificado");
		}

		return rondas;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Persona> leerPronosticoCsv(String rutaPronostico) throws IllegalStateException, IOException {

		List<PronosticoCsv> lineasPronosticoCsv = null;
		List<Persona> personas = new ArrayList<Persona>();

		try {
			lineasPronosticoCsv = new CsvToBeanBuilder(new FileReader(rutaPronostico, StandardCharsets.UTF_8))
					.withSkipLines(1)
					.withType(PronosticoCsv.class)
					.build().parse();

			// mapeo la lista del csv para agruparlos según el nombre del jugador
			Map<String, List<PronosticoCsv>> pronosticoPorJugador = lineasPronosticoCsv.stream()
					.collect(Collectors.groupingBy(PronosticoCsv::getNombreJugador));

			// recorro el Map y guardo los datos en Ronda
			for (Map.Entry<String, List<PronosticoCsv>> entry : pronosticoPorJugador.entrySet()) {
				Persona persona = new Persona();
				persona.setNombre(entry.getKey());
				// al guardar la lista de partidos, transformo PartidoCsv a Partido
				persona.setPronosticos(entry.getValue().stream()
						// filtro solo los datos que estan completos
						.filter(pronsoticoCsv -> {
								try{
									verificarNumeroDeCampos(pronsoticoCsv);
									return true;
								} catch (FaltanDatosExcepcion e) {
									e.getMessage();
									return false;
								}
						})
						// convierto PronosticoCsv a Pronostico
						.map(pronosticoCsv -> ConvertirObjetoCsvAObjeto.pronosticoCsvAPronostico(pronosticoCsv))
						.collect(Collectors.toList()));
				personas.add(persona);
			}

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("No se encuentra el archivo especificado");
		}

		return personas;
	}

	private void verificarNumeroDeCampos(PronosticoCsv pronosticoCsv) throws FaltanDatosExcepcion {

		String mensaje = null;
		
		if (pronosticoCsv.getNombreJugador() == null) {
			mensaje = "Faltan el nombre del jugador";
		}
		if (pronosticoCsv.getNombreEquipo1() == null) {
			mensaje = "Faltan el nombre del primer equipo";
		}
		if (pronosticoCsv.getNombreEquipo2() == null) {
			mensaje = "Faltan el nombre del segundo equipo";
		}
		if (pronosticoCsv.getGanaEquipo1() == null && pronosticoCsv.getGanaEquipo2() == null
				&& pronosticoCsv.getEmpate() == null) {
			mensaje = "Falta asignar 'local', 'empate' o 'visitante'";
		}

		if(mensaje != null) {
			throw new FaltanDatosExcepcion(mensaje);
		}
		
		

	}

}
