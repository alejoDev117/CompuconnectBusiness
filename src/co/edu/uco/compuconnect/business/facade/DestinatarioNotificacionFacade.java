package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.DestinatarioNotificacionDTO;

public interface DestinatarioNotificacionFacade {
	
	void crear(DestinatarioNotificacionDTO dto);
	
	List<DestinatarioNotificacionDTO> consultar(DestinatarioNotificacionDTO dto);
	
	void eliminar(DestinatarioNotificacionDTO dto);

}
