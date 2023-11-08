package org.curso.pronosticos_deportivos.modelos;

import org.curso.pronosticos_deportivos.enumeraciones.ResultadoEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEquipo1;
	private Integer golesEquipo2;
	
	public Partido(PartidoCsv partidoCsv) {
		this.setEquipo1(new Equipo(partidoCsv.getNombreEquipo1()));
		this.setEquipo2(new Equipo(partidoCsv.getNombreEquipo2()));
		this.setGolesEquipo1(Integer.parseInt(partidoCsv.getGolesEquipo1()));
		this.setGolesEquipo2(Integer.parseInt(partidoCsv.getGolesEquipo2()));
	}
	
	public ResultadoEnum resultado(Partido partido) {
		
		if(partido.getGolesEquipo1() > partido.getGolesEquipo2()) {
			return ResultadoEnum.LOCAL;
		}  
		
		if(partido.getGolesEquipo1() < partido.getGolesEquipo2()) {
			return ResultadoEnum.VISITANTE;
		}
		
		return ResultadoEnum.EMPATE;
	}
	
}
