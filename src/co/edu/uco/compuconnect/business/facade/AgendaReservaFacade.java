package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.AgendaReservaDTO;

public interface AgendaReservaFacade {
	
	List<AgendaReservaDTO> consultar(AgendaReservaDTO dto);

}
