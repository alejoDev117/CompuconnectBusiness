package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.PerfilDTO;

public interface PerfilFacade {

	void crear(PerfilDTO dto);
	
	void actualizar(PerfilDTO dto);
	
	void eliminar(PerfilDTO dto);
	
	List<PerfilDTO> consultar(PerfilDTO dto);
	
	
	
}
