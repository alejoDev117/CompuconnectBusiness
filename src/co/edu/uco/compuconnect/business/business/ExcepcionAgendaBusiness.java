package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.ExcepcionAgendaDomain;

public interface ExcepcionAgendaBusiness {

	void asignar(ExcepcionAgendaDomain datosAsignarExcepcionAgenda);
	
	void eliminar(ExcepcionAgendaDomain datosBorrarExcepcionAgenda);
	
	List<ExcepcionAgendaDomain> consultar(ExcepcionAgendaDomain datosFiltroExcepcionAgenda);
	
}
