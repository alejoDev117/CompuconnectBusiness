package co.edu.uco.compuconnect.business.facade;

import java.util.List;
import co.edu.uco.compuconnect.data.dao.AgendaReservaDAO;
import co.edu.uco.compuconnect.dto.AgendaReservaDTO;

public interface AgendaReservaFacade {
	
	void crear(AgendaReservaDTO dto);
	
	List<AgendaReservaDTO>consultar(AgendaReservaDTO dto);
	
	void eliminar(AgendaReservaDTO dto);

}
