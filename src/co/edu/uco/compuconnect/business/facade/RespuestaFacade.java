package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.RespuestaDTO;
public interface RespuestaFacade {

	void realizar(RespuestaDTO dto);
	
	void eliminar(RespuestaDTO dto);
	
	List<RespuestaDTO> consultar(RespuestaDTO dto);
}
