package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.SoftwareDTO;

public interface SoftwareFacade {

	void añadir(SoftwareDTO dto);
	
	void eliminar(SoftwareDTO dto);
	
	List<SoftwareDTO> consultar(SoftwareDTO dto);
	
}
