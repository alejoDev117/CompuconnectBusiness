package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.EstadoNotificacionDTO;

public interface EstadoNotificacionFacade {

	List<EstadoNotificacionDTO> consultar(EstadoNotificacionDTO dto);
	
}
