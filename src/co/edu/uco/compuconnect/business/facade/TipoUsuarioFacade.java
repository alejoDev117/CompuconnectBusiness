package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.TipoUsuarioDTO;

public  interface TipoUsuarioFacade {

	List<TipoUsuarioDTO> consultar(TipoUsuarioDTO dto);
	
	
}
