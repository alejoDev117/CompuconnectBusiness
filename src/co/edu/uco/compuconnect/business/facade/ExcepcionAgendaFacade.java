package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.ExcepcionAgendaDTO;

public interface ExcepcionAgendaFacade {
	
	void asignar(ExcepcionAgendaDTO dto);
	
	void eliminar(ExcepcionAgendaDTO dto);
	
	List<ExcepcionAgendaDTO> consultar(ExcepcionAgendaDTO dto);

}
