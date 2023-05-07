package co.edu.uco.compuconnect.business.business;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoEquipoComputoDomain;

public interface EstadoEquipoComputoBusiness {

	List<EstadoEquipoComputoDomain> consultar(EstadoEquipoComputoDomain datosFiltroEstadoEquipoComputo);
	
	
}
