package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;

public interface EstadoSolicitudBusiness {

	List<EstadoSolicitudDomain> consultar(EstadoSolicitudDomain datosFiltroEstadoSolicitud);
	
	
}
