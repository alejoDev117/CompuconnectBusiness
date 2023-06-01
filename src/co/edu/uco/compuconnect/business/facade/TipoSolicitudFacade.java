package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.TipoSolicitudDTO;

public  interface TipoSolicitudFacade {

	List<TipoSolicitudDTO> consultar(TipoSolicitudDTO dto);
	
	
	
	
}
