package co.edu.uco.compuconnect.business.business;

import java.util.List;


import co.edu.uco.compuconnect.business.domain.TipoSolicitudDomain;


public  interface TipoSolicitudBusiness {

	List<TipoSolicitudDomain> consultar(TipoSolicitudDomain datosFiltroTipoSolicitud);
	
	
}
