package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.TipoReservaDTO;

public  interface TipoReservaFacade {

	List<TipoReservaDTO> consultar(TipoReservaDTO dto);
	
	
}
