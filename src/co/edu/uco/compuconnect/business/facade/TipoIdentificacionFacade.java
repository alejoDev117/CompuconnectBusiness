package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.TipoIdentificacionDomain;
import co.edu.uco.compuconnect.dto.TipoIdentificacionDTO;

public  interface TipoIdentificacionFacade {

	List<TipoIdentificacionDTO> consultar(TipoIdentificacionDTO dto);
	
	
}
