package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.DestinatarioDTO;

public interface DestinatarioFacade {
	
	void registrar(DestinatarioDTO dto);
	
	void modificar(DestinatarioDTO dto);
	
	List<DestinatarioDTO> consultar(DestinatarioDTO dto);
	
	void eliminar(DestinatarioDTO dto);

}
