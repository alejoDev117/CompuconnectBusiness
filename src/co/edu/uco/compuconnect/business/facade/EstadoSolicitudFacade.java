package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EstadoPeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.business.domain.EstadoSolicitudDomain;
import co.edu.uco.compuconnect.dto.EstadoSolicitudDTO;

public interface EstadoSolicitudFacade {

	List<EstadoSolicitudDTO> consultar(EstadoSolicitudDTO dto);
	
	
}
