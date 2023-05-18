package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.BuzonSolicitudDTO;

public interface BuzonSolicitudFacade {
	
	
	void generar(BuzonSolicitudDTO dto);
	
	void actualizar(BuzonSolicitudDTO dto);
	
	List<BuzonSolicitudDTO> consultar(BuzonSolicitudDTO dto);

}
