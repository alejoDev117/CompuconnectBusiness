package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.EstadoPeriodoFuncionamientoDTO;

public interface EstadoPeriodoFuncionamientoFacade {

	List<EstadoPeriodoFuncionamientoDTO> consultar(EstadoPeriodoFuncionamientoDTO dto);
	
	
}
