package org.curso.pronosticos_deportivos.servicios;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;
import org.curso.pronosticos_deportivos.modelos.Equipo;
import org.curso.pronosticos_deportivos.modelos.Partido;
import org.curso.pronosticos_deportivos.modelos.PartidoCsv;
import org.curso.pronosticos_deportivos.modelos.Pronostico;
import org.curso.pronosticos_deportivos.modelos.PronosticoCsv;

public abstract class ConvertirObjetoCsvAObjeto {

	public static Partido partidoCsvAPartido(PartidoCsv partidoCsv) {

		Partido partido = new Partido();
		partido.setEquipo1(new Equipo(partidoCsv.getNombreEquipo1()));
		partido.setEquipo2(new Equipo(partidoCsv.getNombreEquipo2()));
		partido.setGolesEquipo1(partidoCsv.getGolesEquipo1());
		partido.setGolesEquipo2(partidoCsv.getGolesEquipo2());
		return partido;
	}

	public static Pronostico pronosticoCsvAPronostico(PronosticoCsv pronosticoCsv) {

		Pronostico pronostico = new Pronostico();

		Partido partido = new Partido();
		partido.setEquipo1(new Equipo(pronosticoCsv.getNombreEquipo1()));
		partido.setEquipo2(new Equipo(pronosticoCsv.getNombreEquipo2()));
		pronostico.setPartido(partido);
		
		pronostico.setResultado(convertirResultado(pronosticoCsv));
		
		return pronostico;

	}

	private static ResultadoEnum convertirResultado(PronosticoCsv pronosticoCsv) {

		if (pronosticoCsv.getGanaEquipo1().equalsIgnoreCase("x")) {
			return ResultadoEnum.LOCAL;
		}

		if (pronosticoCsv.getGanaEquipo2().equalsIgnoreCase("x")) {
			return ResultadoEnum.VISITANTE;
		}

		return ResultadoEnum.EMPATE;
	}
}
