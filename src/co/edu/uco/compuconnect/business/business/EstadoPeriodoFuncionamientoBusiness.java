package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;

public interface EstadoPeriodoFuncionamientoBusiness {

	List<EstadoPeriodoFuncionamientoDomain> consultar(EstadoPeriodoFuncionamientoDomain datosFiltroFuncionamiento);
	
	
}
