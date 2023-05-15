package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoReservaDomain;

public  interface TipoReservaBusiness {

	List<TipoReservaDomain> consultar(TipoReservaDomain datosFiltroTipoReserva);
	
	
}
