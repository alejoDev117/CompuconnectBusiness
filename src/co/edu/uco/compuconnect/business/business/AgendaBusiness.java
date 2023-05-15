package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.AgendaDomain;

public interface AgendaBusiness {

	void crear(AgendaDomain datosAgenda);
	
	List<AgendaDomain> consultar(AgendaDomain datosFiltroAgenda);
	
	void actualizar(AgendaDomain datosActualizacionAgenda);
	
	void eliminar(AgendaDomain datosEliminacionAgenda);
	
	
	
}
