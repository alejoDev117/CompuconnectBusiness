package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.business.domain.TipoNotificacionDomain;
import co.edu.uco.compuconnect.dto.TipoNotificacionDTO;

public  interface TipoNotificacionFacade {

	List<TipoNotificacionDTO> consultar(TipoNotificacionDTO dto);
	
	
}
