package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.ExcepcionAgendaDTO;

public interface ExcepcionAgendaFacade {
	
	void registrar(ExcepcionAgendaDTO dto);
	
	void modificar(ExcepcionAgendaDTO dto);
	
	List<ExcepcionAgendaDTO> consultar(ExcepcionAgendaDTO dto);
	
	void eliminar(ExcepcionAgendaDTO dto);

}
