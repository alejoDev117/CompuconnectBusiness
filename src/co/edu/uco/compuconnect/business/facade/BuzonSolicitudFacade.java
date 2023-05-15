package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.BuzonSolicitudDTO;

public interface BuzonSolicitudFacade {
	
	List<BuzonSolicitudDTO> consultar(BuzonSolicitudDTO dto);

}
