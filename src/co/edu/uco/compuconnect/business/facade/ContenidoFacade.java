package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.ContenidoDTO;

public interface ContenidoFacade {
	
	void registrar(ContenidoDTO dto);
	
	void modificar(ContenidoDTO dto);
	
	List<ContenidoDTO> consultar(ContenidoDTO dto);
	
	void eliminar(ContenidoDTO dto);

}
