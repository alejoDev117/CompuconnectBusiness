package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.DetalleReservaDTO;

public interface PeriodoFuncionamientoDiaFestivoFacade {
	
	List<DetalleReservaDTO> consultar(DetalleReservaDTO dto);

}
