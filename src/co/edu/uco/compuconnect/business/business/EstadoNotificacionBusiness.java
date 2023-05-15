package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoNotificacionDomain;

public interface EstadoNotificacionBusiness {

	List<EstadoNotificacionDomain> consultar(EstadoNotificacionDomain datosFiltroEstadoNotificacion);
	
}
