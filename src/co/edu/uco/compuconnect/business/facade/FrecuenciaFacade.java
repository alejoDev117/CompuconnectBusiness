package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.FrecuenciaDTO;


public interface FrecuenciaFacade {

	List<FrecuenciaDTO> consultar(FrecuenciaDTO dto);
	
	
}
