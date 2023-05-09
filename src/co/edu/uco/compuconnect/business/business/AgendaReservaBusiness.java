package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.AgendaReservaDomain;

public interface AgendaReservaBusiness {
	
	void crear(AgendaReservaDomain datosAgendaReserva);
	
	List<AgendaReservaDomain>consultar(AgendaReservaDomain datosFiltroAgendaReserva);
	
	void eliminar(AgendaReservaDomain datosEliminacionAgendaReserva);

}
