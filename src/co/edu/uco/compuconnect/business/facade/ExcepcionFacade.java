package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.dto.ExcepcionDTO;

public interface ExcepcionFacade {

	void generar(ExcepcionDTO dto);
	
	void modificar(ExcepcionDTO dto);
	
	void eliminar(ExcepcionDTO dto);
	
	List<ExcepcionDTO> consultar(ExcepcionDTO dto);
	
	
}
