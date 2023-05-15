package co.edu.uco.compuconnect.business.facade;

import java.util.List;

import co.edu.uco.compuconnect.business.domain.CoordinadorDomain;
import co.edu.uco.compuconnect.dto.CoordinadorDTO;

public interface CoordinadorFacade {

	void registrar(CoordinadorDTO dto);
	
	void modificar(CoordinadorDTO dto);
	
	List<CoordinadorDTO> consultar(CoordinadorDTO dto);
	
	void eliminar(CoordinadorDTO dto);
	
}
