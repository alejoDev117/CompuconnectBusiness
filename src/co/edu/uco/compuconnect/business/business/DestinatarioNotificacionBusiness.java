package co.edu.uco.compuconnect.business.business;

import java.util.List;


import co.edu.uco.compuconnect.business.domain.DestinatarioNotificacionDomain;


public interface  DestinatarioNotificacionBusiness {
	
	void crear(DestinatarioNotificacionDomain datosCreacionDestinatarioNotificacion);
	
	List<DestinatarioNotificacionDomain> consultar(DestinatarioNotificacionDomain datosFiltroDestinatarioNotificacion);
	
	void eliminar(DestinatarioNotificacionDomain datosEliminacionDestinatarioNotificacion);
	
	
	
}
