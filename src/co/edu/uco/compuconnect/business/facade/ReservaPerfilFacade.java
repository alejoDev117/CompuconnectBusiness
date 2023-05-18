package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.ReservaPerfilDTO;



public interface ReservaPerfilFacade {
	
	void crear(ReservaPerfilDTO dto);
	
	List<ReservaPerfilDTO>consultar(ReservaPerfilDTO dto);
	
	void eliminar(ReservaPerfilDTO dto);

}
