package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;

public  interface TipoNotificacionBusiness {

	List<TipoNotificacionDomain> consultar(TipoNotificacionDomain datosFiltroTipoNotificacion);
	
	
}
