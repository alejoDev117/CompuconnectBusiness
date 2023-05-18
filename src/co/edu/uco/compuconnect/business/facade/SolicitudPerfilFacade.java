package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.SolicitudPerfilDTO;

public interface SolicitudPerfilFacade {

	void crear(SolicitudPerfilDTO dto);
	
	List<SolicitudPerfilDTO> consultar(SolicitudPerfilDTO dto);
	
	void eliminar(SolicitudPerfilDTO dto);
}
