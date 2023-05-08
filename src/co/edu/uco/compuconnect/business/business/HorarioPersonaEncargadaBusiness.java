package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.HorarioPersonaEncargadaDomain;

public interface HorarioPersonaEncargadaBusiness {

	void asignar(HorarioPersonaEncargadaDomain datosHorario);
	
	void eliminar(HorarioPersonaEncargadaDomain datosEliminacionHorario);
	
	List<HorarioPersonaEncargadaDomain> consultar(HorarioPersonaEncargadaDomain datosFiltroHorario);
	
}
