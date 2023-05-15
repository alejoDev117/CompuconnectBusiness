package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoEquipoComputoDomain;
import co.edu.uco.compuconnect.dto.EstadoEquipoComputoDTO;

public interface EstadoEquipoComputoFacade {

	List<EstadoEquipoComputoDTO> consultar(EstadoEquipoComputoDTO dto);
	
	
}
