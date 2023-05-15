package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.SolicitudDomain;
import co.edu.uco.compuconnect.dto.SolicitudDTO;

public interface SolicitudFacade {

	void crear(SolicitudDTO dto);
	
	void enviar(SolicitudDTO dto);
	
	List<SolicitudDTO> consultar(SolicitudDTO dto);
	
	
}
