package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.business.domain.FrecuenciaDomain;

public interface FrecuenciaBusiness {

	List<FrecuenciaDomain> consultar(FrecuenciaDomain datosFiltroFrecuencia);
	
	
}
