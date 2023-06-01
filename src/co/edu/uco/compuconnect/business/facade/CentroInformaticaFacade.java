package co.edu.uco.compuconnect.business.facade;

import java.util.List;


import co.edu.uco.compuconnect.dto.CentroInformaticaDTO;


public interface CentroInformaticaFacade {

	void create(CentroInformaticaDTO dto);
	
	List<CentroInformaticaDTO> read(CentroInformaticaDTO dto);
	
	void update(CentroInformaticaDTO dto);
	
	void delete(CentroInformaticaDTO dto);
	
	
}
