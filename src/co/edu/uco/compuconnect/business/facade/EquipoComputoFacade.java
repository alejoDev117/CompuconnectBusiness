package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.EquipoComputoDomain;
import co.edu.uco.compuconnect.dto.EquipoComputoDTO;

public interface EquipoComputoFacade {

	void registrar(EquipoComputoDTO dto);
	
	void modificar(EquipoComputoDTO dto);
	
	List<EquipoComputoDTO> consultar(EquipoComputoDTO dto);
	
	void eliminar(EquipoComputoDTO dto);
	
	
}
