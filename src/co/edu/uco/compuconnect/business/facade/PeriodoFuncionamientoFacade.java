package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.PeriodoFuncionamientoDomain;
import co.edu.uco.compuconnect.dto.PeriodoFuncionamientoDTO;

public interface PeriodoFuncionamientoFacade {

	void crear(PeriodoFuncionamientoDTO dto);
	
	void modificar(PeriodoFuncionamientoDTO dto);
	
	void eliminar(PeriodoFuncionamientoDTO dto);
	
	List<PeriodoFuncionamientoDTO> consultar(PeriodoFuncionamientoDTO dto);
	
	
}
