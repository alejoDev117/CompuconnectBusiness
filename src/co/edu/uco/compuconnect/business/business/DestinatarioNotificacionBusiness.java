package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.DestinatarioNotificacionDomain;
import co.edu.uco.compuconnect.business.domain.DetalleReservaDomain;

public interface  DestinatarioNotificacionBusiness {
	
	void crear(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion);
	
	List<DestinatarioNotificacionDomain> consultar(DestinatarioNotificacionDomain datosFiltroDestinatarioNotificacion);
	
	void eliminar(DestinatarioNotificacionDomain datosEliminacionDestinatarioNotificacion);
	
	
	
}
