package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.ContenidoDTO;

public interface ContenidoFacade {
	
	void crear(ContenidoDTO dto);
	
	void eliminar(ContenidoDTO dto);
	
	List<ContenidoDTO> consultar(ContenidoDTO dto);

}
