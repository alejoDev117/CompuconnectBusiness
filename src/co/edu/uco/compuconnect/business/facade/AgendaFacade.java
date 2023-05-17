package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.AgendaDTO;

public interface AgendaFacade {
	
	void registrar(AgendaDTO dto);
	
	void modificar(AgendaDTO dto);
	
	List<AgendaDTO> consultar(AgendaDTO dto);
	
	void eliminar(AgendaDTO dto);

}
