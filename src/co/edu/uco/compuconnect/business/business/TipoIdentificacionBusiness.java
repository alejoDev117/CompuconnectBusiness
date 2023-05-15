package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;

public  interface TipoIdentificacionBusiness {

	List<TipoIdentificacionDomain> consultar(TipoIdentificacionDomain datosFiltroTipoIdentificacion);
	
	
}
