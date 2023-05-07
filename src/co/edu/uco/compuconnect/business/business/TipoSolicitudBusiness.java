package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;
import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;

public  interface TipoSolicitudBusiness {

	List<TipoSolicitudDomain> consultar(TipoSolicitudDomain datosFiltroTipoSolicitud);
	
	
}
