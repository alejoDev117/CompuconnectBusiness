package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.DestinatarioNotificacionDTO;

public interface DestinatarioNotificacionFacade {
	
	List<DestinatarioNotificacionDTO> consultar(DestinatarioNotificacionDTO dto);

}
